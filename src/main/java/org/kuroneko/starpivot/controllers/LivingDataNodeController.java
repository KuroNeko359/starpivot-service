package org.kuroneko.starpivot.controllers;

import org.kuroneko.starpivot.entity.hadoop.DataNodeInfo;
import org.kuroneko.starpivot.services.DataNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/datanodes")
public class LivingDataNodeController {

    @Autowired
    private DataNodeService dataNodeInfo;

    @GetMapping("/alive")
    public Map<String, DataNodeInfo.NodeInfo> getAliveDataNodes() {

        return dataNodeInfo.getAliveDataNodes();
    }
}
