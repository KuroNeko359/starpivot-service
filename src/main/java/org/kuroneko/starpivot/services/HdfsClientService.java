package org.kuroneko.starpivot.services;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

@Service
public class HdfsClientService {
    URI uri = new URI("hdfs://hadoop102:9000/");
    Configuration configuration = new Configuration();
    String user = "root";
    FileSystem fs = FileSystem.get(uri, configuration, user);

    public HdfsClientService()
            throws IOException, InterruptedException, URISyntaxException {

    }

    public boolean createDirectory(String path)
            throws IOException, URISyntaxException, InterruptedException {
        return fs.mkdirs(new Path(path));
    }

    public boolean deleteDirectory(String path)
            throws IOException, URISyntaxException, InterruptedException {

        FileStatus status = fs.getFileStatus(new Path(path));
        if (status.isDirectory()) {
            return fs.delete(new Path(path), true);
        }
        return false;
    }

    public boolean isFileExist(String path) throws IOException {
        return fs.exists(new Path(path));
    }

    public boolean deleteFile(String path)
            throws IOException, URISyntaxException, InterruptedException {
        FileStatus status = fs.getFileStatus(new Path(path));
        if (status.isFile()) {
            return fs.delete(new Path(path), true);
        }
        return false;
    }

//    public boolean uploadFile() {
//        fs.copyFromLocalFile();
//        return false;
//    }

    public boolean createFile() throws IOException {
        // TODO 参数没写
        // 创建文件
        Path filePath = new Path("/test.txt");
        boolean isExist = fs.exists(filePath);
        if (isExist) {
            return false;
        }
        fs.create(filePath, false);
        return true;
    }

    public boolean updateFileContent(InputStream fileInputStream) throws IOException {
        //TODO 未完成 没法选择url
        Path filePath = new Path("/test.txt");
        FSDataOutputStream fsDataOutputStream = fs.create(filePath, true);
        IOUtils.copyBytes(fileInputStream, fsDataOutputStream, configuration);
        return true;
    }
}
