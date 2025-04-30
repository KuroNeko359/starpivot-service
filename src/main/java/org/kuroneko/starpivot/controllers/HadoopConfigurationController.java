package org.kuroneko.starpivot.controllers;

import org.dom4j.DocumentException;
import org.kuroneko.starpivot.entity.Configuration;
import org.kuroneko.starpivot.entity.response.SuccessResponse;
import org.kuroneko.starpivot.services.HadoopConfigurationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hadoop-configure")
public class HadoopConfigurationController {

    private final HadoopConfigurationService hadoopConfigurationService;

    public HadoopConfigurationController(HadoopConfigurationService hadoopConfigurationService) {
        this.hadoopConfigurationService = hadoopConfigurationService;
    }

    @PostMapping("core-site")
    public ResponseEntity<?> addProperty(@RequestParam List<Configuration> configurations)
            throws DocumentException {
        hadoopConfigurationService.setupCoreSite(configurations);
        return ResponseEntity.ok()
                .body(new SuccessResponse("sucess", HttpStatus.OK));
    }

}
