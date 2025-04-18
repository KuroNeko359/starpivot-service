package org.kuroneko.starpivot.controllers;

import org.kuroneko.starpivot.entity.response.Response;
import org.kuroneko.starpivot.entity.response.SuccessResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Base64;

@RestController
@RequestMapping("/test")
public class TestController {

    @PostMapping("/file-upload")
    public Response test(@RequestParam String fileInBase64) {
        byte[] decode = Base64.getDecoder().decode(fileInBase64);
        String string = Arrays.toString(decode);
        Logger logger = LoggerFactory.getLogger(TestController.class);
        logger.info(string);
        return new SuccessResponse("sucess", HttpStatus.OK);
    }
}
