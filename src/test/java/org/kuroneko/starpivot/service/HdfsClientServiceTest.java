package org.kuroneko.starpivot.service;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.junit.jupiter.api.Test;
import org.kuroneko.starpivot.entity.FileSystemItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;

public class HdfsClientServiceTest {
    private static final Logger log = LoggerFactory.getLogger(HdfsClientServiceTest.class);
    URI uri = new URI("hdfs://hadoop102:9000/");
    Configuration configuration = new Configuration();
    String user = "root";
    FileSystem fs = FileSystem.get(uri, configuration, user);

    public HdfsClientServiceTest() throws IOException, InterruptedException, URISyntaxException {
    }

    @Test
    public void createDirectory() throws IOException, URISyntaxException, InterruptedException {

        fs.mkdirs(new Path("/files"));
    }

    @Test
    public void deleteDirectory()
            throws IOException, URISyntaxException, InterruptedException {

        FileStatus status = fs.getFileStatus(new Path("/files"));
        if (status.isDirectory()) {
            fs.delete(new Path("/files"), true);
            log.info("Successfully deleted file");
        } else {
            log.info("Deleted file error");
        }

    }

    @Test
    public void deleteFile()
            throws IOException, URISyntaxException, InterruptedException {
        FileStatus status = fs.getFileStatus(new Path("/files"));
        if (status.isFile()) {
            fs.delete(new Path("/files"), true);
            log.info("Successfully deleted file");
        } else {
            log.info("Deleted file error");
        }

    }

    @Test
    public void uploadFromFileStream() {

    }

    @Test
    public void getFileStatus() throws IOException {
//        Path path = new Path("/starpivot");
//        log.info("Path: {}", path);
//        RemoteIterator<FileStatus> fileStatusRemoteIterator = fs.listStatusIterator(path);
//        while (fileStatusRemoteIterator.hasNext()) {
//            FileStatus fileStatus = fileStatusRemoteIterator.next();
//
//            FileSystemRoot fileSystemRoot = new FileSystemRoot();
//            fileSystemRoot.putItems(FileSystemItem.fromFileStatus(fileStatus));
//
//            List<FileSystemItem> items = fileSystemRoot.getItems();
//            items.forEach(item -> {
//                log.info("File:{}", item);
//                if (item.isFile()) {
//                    log.info("File:{}", item);
//                } else if (item.isDirectory()) {
//                    log.info("Directory:{}", item);
//                }
//            });
//        }
    }


    @Test
    public void getFiles() throws IOException {
        Path path = new Path("/starpivot");
        RemoteIterator<LocatedFileStatus> locatedFileStatusRemoteIterator = fs.listLocatedStatus(path);
        FileSystemItem root = new FileSystemItem();

        while (locatedFileStatusRemoteIterator.hasNext()) {
            LocatedFileStatus next = locatedFileStatusRemoteIterator.next();
            FileSystemItem fileSystemItem = new FileSystemItem(next);
            log.info("FileSystemItem:{}", fileSystemItem);
            root.addChildren(fileSystemItem);
        }
//
//        RemoteIterator<LocatedFileStatus> locatedFileStatusRemoteIterator1 = fs.listLocatedStatus(path);
//        while (locatedFileStatusRemoteIterator1.hasNext()) {
//            LocatedFileStatus next = locatedFileStatusRemoteIterator1.next();
//            log.info("LocatedFileStatus:{}", next);
//        }

    }


    @Test
    public void getFileContent() throws IOException {
        Path path = new Path("hdfs://hadoop102:9000/hadoop/etc/hadoop/hadoop-env.sh");
        FSDataInputStream open = fs.open(path);
        final int FILE_LENGTH = 64;
        byte[] bytes = new byte[FILE_LENGTH];

        int bytesRead = open.read(bytes);
        // 如果文件内容超过预定义长度，可以循环读取
        while (bytesRead != -1) {
            // 处理读取到的字节数组内容
            String content = new String(bytes, 0, bytesRead);
            System.out.print(content);
            bytesRead = open.read(bytes);
        }


        open.close();
    }

    private String bytesToString(byte[] input, FSDataInputStream fsDataInputStream) throws IOException {
        int bytesRead = fsDataInputStream.read(input);
        String content = null;
        if (bytesRead != -1) {
            content = new String(input, 0, bytesRead, StandardCharsets.UTF_8);
        } else {
            log.error("No content read from the file.");
        }
        return content;
    }


    @Test
    public void testUriToPath() throws URISyntaxException {
        URI uri1 = new URI("hdfs://hadoop102:9000/");
        System.out.println(uri1.resolve("/path"));

    }

    /**
     * 获取HDFS中文件的输入流。
     *
     * @param pathInHdfs HDFS中文件的路径。
     * @return 文件的输入流。
     * @throws IOException 如果发生I/O错误。
     */
    public FSDataInputStream getFSDataInputStream(String pathInHdfs)
            throws IOException {
        Path path = getPath(pathInHdfs);
        return fs.open(path);
    }

    /**
     * 将字符串路径转换为Hadoop Path对象。
     *
     * @param pathInHdfs HDFS中文件的路径。
     * @return Hadoop Path对象。
     */
    public Path getPath(String pathInHdfs) {
        return new Path(uri.resolve(pathInHdfs));
    }


    public String getFileHead(String pathInHdfs)
            throws IOException {
        FSDataInputStream fsDataInputStream = getFSDataInputStream(pathInHdfs);
        int bufferSize = 32768;
        byte[] buffer = new byte[bufferSize];
        int bytesRead = fsDataInputStream.read(buffer, 0, bufferSize);
        String result = "";
        if (bytesRead > 0) {
            result = new String(buffer, 0, bytesRead, StandardCharsets.UTF_8);
        }
        return result;
    }

    @Test
    public void testFileHead() throws IOException {
        String fileHead = getFileHead("hdfs://hadoop102:9000/hadoop/LICENSE.txt");
        System.out.println(fileHead);

    }

}
