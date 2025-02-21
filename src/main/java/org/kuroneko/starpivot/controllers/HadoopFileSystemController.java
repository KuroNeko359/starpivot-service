package org.kuroneko.starpivot.controllers;

import org.kuroneko.starpivot.services.HdfsClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

@RestController
@RequestMapping("hdfs")
public class HadoopFileSystemController {

    public final HdfsClientService hdfsClientService = new HdfsClientService();
    public static final Logger logger = LoggerFactory.getLogger(HadoopFileSystemController.class);

    public HadoopFileSystemController() throws IOException, URISyntaxException, InterruptedException {

    }

    @PostMapping("/create-directory")
    public ResponseEntity<String> createDirectory(@RequestParam String path)
            throws IOException, URISyntaxException, InterruptedException {
        boolean isCreated = hdfsClientService.createDirectory(path);
        if (isCreated) {
            return new ResponseEntity<>("Directory created successfully.", HttpStatus.CREATED);
        }
        if (hdfsClientService.isFileExist(path)) {
            return new ResponseEntity<>("Directory already exist.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Directory not created.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/delete-directory")
    public ResponseEntity<String> deleteDirectory(@RequestParam String path) throws IOException, URISyntaxException, InterruptedException {
        boolean isDeleted = hdfsClientService.deleteDirectory(path);
        if (isDeleted) {
            return new ResponseEntity<>("Directory deleted successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Directory could not be deleted or not exist.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/delete-file")
    public ResponseEntity<String> deleteFile(@RequestParam String path) throws IOException, URISyntaxException, InterruptedException {
        boolean isDeleted = hdfsClientService.deleteFile(path);
        if (isDeleted) {
            return new ResponseEntity<>("File deleted successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("File could not be deleted or not exist.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam MultipartFile file) throws IOException, URISyntaxException, InterruptedException {
        logger.info("Uploading file to HDFS");

        hdfsClientService.createFile();
        hdfsClientService.updateFileContent(file.getInputStream());

        logger.info(file.getOriginalFilename());
        return new ResponseEntity<>("File upload successfully.", HttpStatus.OK);
    }
}
