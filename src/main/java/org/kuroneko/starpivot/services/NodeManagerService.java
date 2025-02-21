package org.kuroneko.starpivot.services;

import org.kuroneko.starpivot.entity.hadoop.NodeManagerInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class NodeManagerService {
    public static final Logger logger = LoggerFactory.getLogger(NodeManagerService.class);

    public Map<String, NodeManagerInfo.Nodes.NodeInfo> getAliveNodes() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://192.168.62.131:8088/ws/v1/cluster/nodes"; // 加上"http://"

        NodeManagerInfo nodeManagerInfo = restTemplate.getForObject(url, NodeManagerInfo.class);

        // 使用 HashMap 来存储存活节点
        HashMap<String, NodeManagerInfo.Nodes.NodeInfo> aliveNodes = new HashMap<>();

        // 如果 nodeManagerInfo 为 null，记录日志并返回空的 Map
        if (nodeManagerInfo == null) {
            logger.info("No nodeManagerInfo found");
            return aliveNodes; // 返回空的 Map，避免方法结束
        }

        // 如果 nodeManagerInfo.getNodes() 为 null，记录日志并返回空的 Map
        NodeManagerInfo.Nodes nodes = nodeManagerInfo.getNodes();
        if (nodes == null) {
            logger.info("No nodes found");
            return aliveNodes; // 返回空的 Map，避免方法结束
        }

        // 如果 nodes.getNodeList() 为 null，记录日志并返回空的 Map
        if (nodes.getNodeList() == null) {
            logger.info("Node list is empty");
            return aliveNodes; // 返回空的 Map，避免方法结束
        }

        // 遍历节点列表并添加到 aliveNodes 中
        nodes.getNodeList().forEach(node -> {
            if (node != null && node.nodeHostName != null) {
                aliveNodes.put(node.nodeHostName, node);
            } else {
                logger.warn("Node or nodeHostName is null, skipping...");
            }
        });

        return aliveNodes; // 返回最终结果
    }
}
