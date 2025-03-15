package org.kuroneko.starpivot.test;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.junit.jupiter.api.Test;
import org.kuroneko.starpivot.entity.hadoop.File;
import org.kuroneko.starpivot.services.HdfsClientService;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

public class URIParseTest {
    HdfsClientService hdfsClientService = new HdfsClientService();

    public URIParseTest() throws IOException, URISyntaxException, InterruptedException {
    }

    @Test
    public void testParseURI() throws URISyntaxException, UnsupportedEncodingException {
        URI path = new URI(encodeURL("hdfs://hadoop102:9000/新建 Microsoft PowerPoint 演示文稿.pptx"));
        System.out.println(path);
    }

    public String encodeURL(String url) throws UnsupportedEncodingException {
        return URLEncoder.encode(url,"UTF-8");
    }

    public String decodeURL(String url) throws UnsupportedEncodingException {
        return URLDecoder.decode(url,"UTF-8");
    }

    /**
     * 测试能否从Hadoop上读取带空格的路径
     */
    @Test
    public void testReadFromHadoop() throws IOException, URISyntaxException, InterruptedException {
        URI path = new URI(encodeURL("hdfs://hadoop102:9000/新建 Microsoft PowerPoint 演示文稿.pptx"));
        if (hdfsClientService.isFileExist(decodeURL(path.toString()))){
            System.out.println("File is exist");
        }else {
            System.out.println("File is not exist");
        }
    }

    @Test
    public void testGetFiles() throws URISyntaxException, IOException, InterruptedException {
        List<File> fileSystemItemCurrentPath = hdfsClientService.getFileSystemItemCurrentPath("/");
        fileSystemItemCurrentPath.forEach(System.out::println);
    }
}
