package org.kuroneko.starpivot.controllers;

import org.kuroneko.starpivot.entity.hadoop.NodeManagerInfo;
import org.kuroneko.starpivot.services.NodeManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * REST 控制器，用于管理存活的 Hadoop NodeManager 节点信息。
 * 该控制器提供 HTTP 接口，用于查询当前活跃的 NodeManager 节点的状态数据。
 * 所有请求都以 "/nodemanager" 为基础路径，通过 Spring MVC 框架处理。
 */
@RestController
@RequestMapping("/nodemanager")
public class LivingNodeManagerController {

    /**
     * NodeManager 服务实例，通过 Spring 的依赖注入自动装配。
     * 该服务负责与底层 Hadoop 集群交互，获取 NodeManager 相关数据。
     */
    @Autowired
    private NodeManagerService nodeManagerService;

    /**
     * 获取当前存活的 NodeManager 节点信息。
     * 该方法通过 HTTP GET 请求返回一个映射表，键为节点标识符，值为对应的节点信息对象。
     * 请求路径为 "/nodemanager/alive"。
     *
     * @return 一个 Map 对象，其中键为节点标识符 (String)，值为节点信息对象
     *         ({@link NodeManagerInfo.Nodes.NodeInfo})。如果没有存活节点，则返回空 Map。
     * @see NodeManagerService#getAliveNodes()
     */
    @GetMapping("/alive")
    public Map<String, NodeManagerInfo.Nodes.NodeInfo> getAliveDataNodes() {
        return nodeManagerService.getAliveNodes();
    }
}