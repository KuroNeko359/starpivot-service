package org.kuroneko.starpivot.service;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

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
        }else {
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
        }else {
            log.info("Deleted file error");
        }

    }

    @Test
    public void uploadFromFileStream() {

    }
}
