package org.kuroneko.starpivot.controllers;

import org.kuroneko.starpivot.entity.Property;
import org.kuroneko.starpivot.services.hadoop.HadoopNativeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HadoopJMXController {

    private final HadoopNativeService hadoopNativeService;

    public HadoopJMXController(HadoopNativeService hadoopNativeService) {
        this.hadoopNativeService = hadoopNativeService;
    }


    @GetMapping("hadoop-url")
    public String getHadoopUrl() {
        return hadoopNativeService.getHadoopUrl();
    }

    @GetMapping("jmx")
    public String getJmx(@RequestParam(required = false) String qry,
                         @RequestParam(required = false) String get,
                         @RequestParam(required = false) String name) {

        return hadoopNativeService.getJmx(qry, get, name);
    }

    @GetMapping({"logs", "logs/{filename}"})
    public String getLogs(@PathVariable(required = false) String filename) {

        return hadoopNativeService.getLogs(filename);
    }

    @GetMapping("logLevel")
    public String getLogLevel(
            @RequestParam(required = false) String log
            ,@RequestParam(required = false) String level) {
        return hadoopNativeService.logLevel(log,level);
    }

    @GetMapping("conf")
    public List<Property> getConf() {
        return hadoopNativeService.getConf();
    }


}
