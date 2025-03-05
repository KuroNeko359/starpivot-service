package org.kuroneko.starpivot.controllers;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.kuroneko.starpivot.entity.file.FileDetail;
import org.kuroneko.starpivot.entity.hadoop.File;
import org.kuroneko.starpivot.services.HdfsClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

/**
 * 用于管理 Hadoop 分布式文件系统 (HDFS) 操作的 REST 控制器。
 * 提供创建/删除目录和文件、上传/下载文件以及获取文件系统信息的端点。
 */
@RestController
@RequestMapping("hdfs")
public class HadoopFileSystemController {

    private final HdfsClientService hdfsClientService = new HdfsClientService();
    private static final Logger logger = LoggerFactory.getLogger(HadoopFileSystemController.class);

    /**
     * 构造一个新的 HadoopFileSystemController 实例。
     *
     * @throws IOException          如果初始化过程中发生 I/O 错误
     * @throws URISyntaxException   如果初始化过程中发生 URI 语法错误
     * @throws InterruptedException 如果初始化过程被中断
     */
    public HadoopFileSystemController() throws IOException, URISyntaxException, InterruptedException {
    }

    /**
     * 在 HDFS 中指定路径创建新目录。
     *
     * @param path 要创建目录的 HDFS 路径
     * @return 包含成功消息和 HTTP 状态的 ResponseEntity
     * @throws IOException          如果创建目录时发生 I/O 错误
     * @throws URISyntaxException   如果提供的路径具有无效的 URI 语法
     * @throws InterruptedException 如果操作被中断
     */
    @PostMapping("/create-directory")
    public ResponseEntity<String> createDirectory(@RequestParam String path)
            throws IOException, URISyntaxException, InterruptedException {
        boolean isCreated = hdfsClientService.createDirectory(path);
        if (isCreated) {
            return new ResponseEntity<>("目录创建成功。", HttpStatus.CREATED);
        }
        if (hdfsClientService.isFileExist(path)) {
            return new ResponseEntity<>("目录已存在。", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("目录创建失败。", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * 从 HDFS 中删除指定路径的目录。
     *
     * @param path 要删除的 HDFS 目录路径
     * @return 包含成功或错误消息和 HTTP 状态的 ResponseEntity
     * @throws IOException          如果删除时发生 I/O 错误
     * @throws URISyntaxException   如果提供的路径具有无效的 URI 语法
     * @throws InterruptedException 如果操作被中断
     */
    @PostMapping("/delete-directory")
    public ResponseEntity<String> deleteDirectory(@RequestParam String path)
            throws IOException, URISyntaxException, InterruptedException {
        boolean isDeleted = hdfsClientService.deleteDirectory(path);
        if (isDeleted) {
            return new ResponseEntity<>("目录删除成功。", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("目录删除失败或不存在。", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 从 HDFS 中删除指定路径的文件。
     *
     * @param path 要删除的 HDFS 文件路径
     * @return 包含成功或错误消息和 HTTP 状态的 ResponseEntity
     * @throws IOException          如果删除时发生 I/O 错误
     * @throws URISyntaxException   如果提供的路径具有无效的 URI 语法
     * @throws InterruptedException 如果操作被中断
     */
    @PostMapping("/delete-file")
    public ResponseEntity<String> deleteFile(@RequestParam String path)
            throws IOException, URISyntaxException, InterruptedException {
        boolean isDeleted = hdfsClientService.deleteFile(path);
        if (isDeleted) {
            return new ResponseEntity<>("文件删除成功。", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("文件删除失败或不存在。", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 将文件上传到 HDFS。
     *
     * @param file 要上传的 MultipartFile 文件
     * @return 包含成功或错误消息和 HTTP 状态的 ResponseEntity
     * @throws IOException          如果上传过程中发生 I/O 错误
     * @throws URISyntaxException   如果路径具有无效的 URI 语法
     * @throws InterruptedException 如果操作被中断
     */
    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam MultipartFile file)
            throws IOException, URISyntaxException, InterruptedException {
        logger.info("正在将文件上传到 HDFS");

        boolean isCreate = hdfsClientService.createFile();
        if (!isCreate) {
            return new ResponseEntity<>("文件创建失败。", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        boolean isUpdate = hdfsClientService.updateFileContent(file.getInputStream());
        if (!isUpdate) {
            return new ResponseEntity<>("文件写入失败。", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        logger.info(file.getOriginalFilename());
        return new ResponseEntity<>("文件上传成功。", HttpStatus.OK);
    }

    /**
     * 获取指定路径下的文件系统项列表。
     *
     * @param body 包含路径的请求体，键为 "path"
     * @return 文件系统项的列表
     * @throws IOException 如果获取文件系统项时发生 I/O 错误
     */
    @PostMapping(value = "/files")
    public List<File> getFileSystemItem(@RequestBody Map<String, String> body)
            throws IOException, URISyntaxException {
        String path = body.get("path");
        return hdfsClientService.getFileSystemItemCurrentPath(path);
    }

    /**
     * 从 HDFS 下载指定路径的文件。
     *
     * @param urlInHdfs HDFS 中文件的路径
     * @return 包含文件流和 HTTP 头信息的 ResponseEntity
     * @throws IOException 如果下载过程中发生 I/O 错误
     */
    @RequestMapping(value = "/download-file", method = RequestMethod.GET)
    public ResponseEntity<?> downloadFile(@RequestParam("path") String urlInHdfs)
            throws IOException {
        if (urlInHdfs == null || urlInHdfs.trim().isEmpty()) {
            return new ResponseEntity<>("无效的 URL。", HttpStatus.BAD_REQUEST);
        }

        FSDataInputStream inputStream = hdfsClientService.getFSDataInputStream(urlInHdfs);
        FileStatus fileStatus = hdfsClientService.getFileStatus(urlInHdfs);
        Path path = hdfsClientService.getPath(urlInHdfs);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", path.getName()));
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(fileStatus.getLen())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new InputStreamResource(inputStream));
    }

    /**
     * 获取 HDFS 中指定路径文件的前几行内容。
     *
     * @param pathInHdfs HDFS 中文件的路径
     * @return 包含文件头部内容的 ResponseEntity
     * @throws IOException 如果读取文件头部时发生 I/O 错误
     */
    @RequestMapping(value = "/file-head", method = RequestMethod.GET)
    public ResponseEntity<FileDetail> getFileHead(@RequestParam("path") String pathInHdfs) throws IOException {
        String fileHead = hdfsClientService.getFileHead(pathInHdfs);
        return ResponseEntity
                .ok()
                .body(new FileDetail(pathInHdfs, fileHead));
    }
}