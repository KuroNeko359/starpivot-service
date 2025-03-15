package org.kuroneko.starpivot.services;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;
import org.kuroneko.starpivot.entity.hadoop.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * HDFS客户端服务类，用于与Hadoop文件系统进行交互。
 */
@Service
public class HdfsClientService {
    private static final Logger log = LoggerFactory.getLogger(HdfsClientService.class);

    // Hadoop文件系统的URI
    // TODO 开放给用户配置
    private final URI uri = new URI("hdfs://hadoop102:9000/");

    // Hadoop配置
    private final Configuration configuration = new Configuration();

    // Hadoop文件系统用户
    private final String user = "root";

    // Hadoop文件系统实例
    private final FileSystem fs = FileSystem.get(uri, configuration, user);

    /**
     * HdfsClientService构造函数。
     *
     * @throws IOException          如果发生I/O错误。
     * @throws InterruptedException 如果当前线程被中断。
     * @throws URISyntaxException   如果URI语法不正确。
     */
    public HdfsClientService()
            throws IOException, InterruptedException, URISyntaxException {
    }

    /**
     * 在HDFS中创建目录。
     *
     * @param path 目录路径。
     * @return 如果目录创建成功，则返回true，否则返回false。
     * @throws IOException          如果发生I/O错误。
     * @throws URISyntaxException   如果URI语法不正确。
     * @throws InterruptedException 如果当前线程被中断。
     */
    public boolean createDirectory(String path)
            throws IOException, URISyntaxException, InterruptedException {
        return fs.mkdirs(new Path(path));
    }

    /**
     * 删除HDFS中的目录。
     *
     * @param path 目录路径。
     * @return 如果目录删除成功，则返回true，否则返回false。
     * @throws IOException          如果发生I/O错误。
     * @throws URISyntaxException   如果URI语法不正确。
     * @throws InterruptedException 如果当前线程被中断。
     */
    public boolean deleteDirectory(String path)
            throws IOException, URISyntaxException, InterruptedException {
        FileStatus status = fs.getFileStatus(new Path(path));
        if (status.isDirectory()) {
            return fs.delete(new Path(path), true);
        }
        return false;
    }

    /**
     * 检查HDFS中是否存在文件。
     *
     * @param path 文件路径。
     * @return 如果文件存在，则返回true，否则返回false。
     * @throws IOException 如果发生I/O错误。
     */
    public boolean isFileExist(String path)
            throws IOException {
        return fs.exists(new Path(path));
    }

    /**
     * 删除HDFS中的文件。
     *
     * @param path 文件路径。
     * @throws IOException 如果发生I/O错误。
     */
    public void deleteFile(String path)
            throws IOException{
        FileStatus status = fs.getFileStatus(new Path(path));
        if (status.isFile()) {
            fs.delete(new Path(path), true);
        }
    }



    /**
     * 在HDFS中创建文件。
     *
     * @return 如果文件创建成功，则返回true，否则返回false。
     * @throws IOException 如果发生I/O错误。
     */
    //TODO 未完成
    public boolean createFile(Path pathInHdfs, String fileName)
            throws IOException {
        boolean isExist = fs.exists(pathInHdfs);
        if (isExist) {
            return false;
        }
        fs.create(pathInHdfs, false);
        return true;
    }

    /**
     * 更新HDFS中文件的内容。
     *
     * @param fileInputStream 文件内容的输入流。
     * @return 如果文件内容更新成功，则返回true，否则返回false。
     * @throws IOException 如果发生I/O错误。
     */
    // TODO 未完成
    public boolean updateFileContent(Path pathInHdfs, InputStream fileInputStream)
            throws IOException {
        FSDataOutputStream fsDataOutputStream = fs.create(pathInHdfs, true);
        IOUtils.copyBytes(fileInputStream, fsDataOutputStream, configuration);
        return true;
    }

    /**
     * 获取指定目录中的文件列表。
     *
     * @param path 目录路径。
     * @return 目录中的文件列表。
     * @throws IOException 如果发生I/O错误。
     */
    public List<File> getFileSystemItemCurrentPath(String path)
            throws IOException, URISyntaxException {
        Path currentPath = new Path(path);
        RemoteIterator<LocatedFileStatus> locatedFileStatusRemoteIterator = fs.listLocatedStatus(currentPath);
        List<File> files = new ArrayList<>();
        while (locatedFileStatusRemoteIterator.hasNext()) {
            LocatedFileStatus locatedFileStatus = locatedFileStatusRemoteIterator.next();
            files.add(new File(locatedFileStatus));
        }
        return files;
    }

    /**
     * 获取文件内容。
     *
     * @param path 文件路径。
     * @return 文件内容详情。
     * @throws IOException 如果发生I/O错误。
     */
//    public FileDetail getFileContent(String path)
//            throws IOException {
//        return new FileDetail();
//    }

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
     * 获取Hadoop文件系统实例。
     *
     * @return Hadoop文件系统实例。
     */
    public FileSystem getFileSystem() {
        return fs;
    }


    /**
     * 获取Hadoop文件的BlockLocations
     *
     * @param pathInHdfs 文件在Hadoop中的路径
     * @return Hadoop文件的BlockLocation[]
     */
    public BlockLocation[] getBlockLocations(String pathInHdfs) throws IOException {
        FileStatus status = getFileStatus(pathInHdfs);
        return fs.getFileBlockLocations(status, 0, status.getLen());
    }


    /**
     * 获取HDFS中文件的FileStatus。
     *
     * @param pathInHdfs HDFS中文件的路径。
     * @return 文件状态(FileStatus)。
     * @throws IOException 如果发生I/O错误。
     */
    public FileStatus getFileStatus(String pathInHdfs)
            throws IOException {
        Path path = getPath(pathInHdfs);
        return fs.getFileStatus(path);
    }

    /**
     * 获取HDFS中文件的LocatedFileStatus
     *
     * @param pathInHdfs HDFS中文件的路径。
     * @return 文件的状态(LocatedFileStatus)。
     * @throws IOException 如果发生I/O错误。
     */
    public LocatedFileStatus getLocatedFileStatus(String pathInHdfs)
            throws IOException {

        return new LocatedFileStatus(getFileStatus(pathInHdfs), getBlockLocations(pathInHdfs));
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

    /**
     * 获取文件的前32kb
     *
     * @param pathInHdfs HDFS中文件的路径。
     * @return 文件前32kb String
     */
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

    /**
     * 获取文件信息
     *
     * @param pathInHdfs HDFS中的路径
     */
//    public String getFileInformation(String pathInHdfs) throws IOException {
//        FileStatus status = getFileStatus(pathInHdfs);
//        return new LocatedFileStatus()
//    }


}