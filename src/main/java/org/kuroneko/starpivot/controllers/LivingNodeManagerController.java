package org.kuroneko.starpivot.controllers;

import org.kuroneko.starpivot.entity.hadoop.NodeManagerInfo;
import org.kuroneko.starpivot.services.NodeManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/nodemanager")
public class LivingNodeManagerController {
    @Autowired
    NodeManagerService nodeManagerService;

    @GetMapping("/alive")
    public Map<String, NodeManagerInfo.Nodes.NodeInfo>  getAliveDataNodes() {

        return nodeManagerService.getAliveNodes();
    }
}
