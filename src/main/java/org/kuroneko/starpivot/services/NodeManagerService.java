package org.kuroneko.starpivot.services;

import org.kuroneko.starpivot.entity.hadoop.NodeManagerInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * 服务类，用于获取和管理 Hadoop 集群中存活的 NodeManager 节点信息。
 * 该类通过 REST API 从指定的 Hadoop 集群地址查询节点状态，并返回存活节点的详细信息。
 * 使用 Spring 的 {@code @Service} 注解标记为服务组件，支持依赖注入。
 */
@Service
public class NodeManagerService {

    /**
     * 日志记录器，用于记录服务运行时的信息、警告和错误。
     * 通过 SLF4J 的 {@link LoggerFactory} 初始化，绑定到当前类。
     */
    public static final Logger logger = LoggerFactory.getLogger(NodeManagerService.class);

    /**
     * 获取当前存活的 NodeManager 节点信息。
     * 该方法通过 REST 请求从 Hadoop 集群的 Web 服务接口获取节点数据，
     * 并返回一个映射表，键为节点的主机名，值为对应的节点信息对象。
     * 如果请求失败或数据为空，将返回一个空的 Map，并记录相应的日志。
     *
     * <p>实现逻辑：
     * <ol>
     *   <li>使用 {@link RestTemplate} 发送 GET 请求到指定的集群 URL。</li>
     *   <li>解析响应为 {@link NodeManagerInfo} 对象。</li>
     *   <li>检查返回数据的完整性，若为空则记录日志并返回空 Map。</li>
     *   <li>遍历节点列表，筛选存活节点并存储到 Map 中。</li>
     * </ol>
     *
     * @return 一个 Map 对象，其中键为节点主机名 (String)，值为节点信息对象
     *         ({@link NodeManagerInfo.Nodes.NodeInfo})。如果没有存活节点或请求失败，则返回空 Map。
     */
    public Map<String, NodeManagerInfo.Nodes.NodeInfo> getAliveNodes() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://192.168.62.131:8088/ws/v1/cluster/nodes"; // Hadoop 集群的节点信息接口

        // 发送 REST 请求并获取节点信息
        NodeManagerInfo nodeManagerInfo = restTemplate.getForObject(url, NodeManagerInfo.class);

        // 初始化存活节点的结果集
        HashMap<String, NodeManagerInfo.Nodes.NodeInfo> aliveNodes = new HashMap<>();

        // 检查 nodeManagerInfo 是否为空
        if (nodeManagerInfo == null) {
            logger.info("No nodeManagerInfo found");
            return aliveNodes; // 返回空 Map
        }

        // 检查节点集合是否为空
        NodeManagerInfo.Nodes nodes = nodeManagerInfo.getNodes();
        if (nodes == null) {
            logger.info("No nodes found");
            return aliveNodes; // 返回空 Map
        }

        // 检查节点列表是否为空
        if (nodes.getNodeList() == null) {
            logger.info("Node list is empty");
            return aliveNodes; // 返回空 Map
        }

        // 遍历节点列表，筛选有效节点并加入结果集
        nodes.getNodeList().forEach(node -> {
            if (node != null && node.nodeHostName != null) {
                aliveNodes.put(node.nodeHostName, node);
            } else {
                logger.warn("Node or nodeHostName is null, skipping...");
            }
        });

        return aliveNodes; // 返回存活节点的结果
    }
}