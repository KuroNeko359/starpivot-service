package org.kuroneko.starpivot.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.kuroneko.starpivot.entity.hadoop.DataNodeInfo;
import org.kuroneko.starpivot.entity.hadoop.HadoopInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * 服务类，用于与 Hadoop NameNode 交互并检索有关存活 DataNodes 的信息。
 */
@Service
public class DataNodeService {
    public static final Logger logger = LoggerFactory.getLogger(DataNodeService.class);

    /**
     * 从 Hadoop NameNode 检索存活 DataNodes 的映射。
     *
     * @return 一个映射，其中键是 DataNode 标识符，值是表示存活 DataNodes 的 DataNodeInfo.NodeInfo 对象。
     */
    public Map<String, DataNodeInfo.NodeInfo> getAliveDataNodes() {

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://192.168.62.131:9870/jmx?qry=Hadoop:service=NameNode,name=NameNodeInfo";

        // 从 URL 获取 HadoopInfo
        HadoopInfo hadoopInfo = restTemplate.getForObject(url, HadoopInfo.class);
        if (hadoopInfo == null) {
            logger.error("无法检索 HadoopInfo");
            return new HashMap<String, DataNodeInfo.NodeInfo>();
        }

        // 提取 liveNodes JSON 字符串
        String liveNodes = hadoopInfo.getBeans().get(0).getLiveNodes();
        if (liveNodes == null || liveNodes.isEmpty()) {
            logger.error("LiveNodes 数据为空或为 null: {}", liveNodes);
            return new HashMap<String, DataNodeInfo.NodeInfo>();
        }

        // 将 liveNodes JSON 字符串解析为 NodeInfo 对象
        ObjectMapper objectMapper = new ObjectMapper();
        DataNodeInfo nodeInfo;
        try {
            nodeInfo = objectMapper.readValue(liveNodes, DataNodeInfo.class);
        } catch (IOException e) {
            logger.error("解析 liveNodes JSON 失败", e);
            return new HashMap<String, DataNodeInfo.NodeInfo>();
        }

        return nodeInfo.getNodes();
    }
}