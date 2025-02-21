package org.kuroneko.starpivot.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.kuroneko.starpivot.entity.hadoop.DataNodeInfo;
import org.kuroneko.starpivot.entity.hadoop.HadoopInfo;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;


public class DataNodeService {

    public DataNodeInfo.NodeInfo getAliveDataNodes() {

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://192.168.62.131:9870/jmx?qry=Hadoop:service=NameNode,name=NameNodeInfo";

        // Get HadoopInfo from the URL
        HadoopInfo hadoopInfo = restTemplate.getForObject(url, HadoopInfo.class);
        if (hadoopInfo == null) {
            throw new RuntimeException("Failed to retrieve HadoopInfo");
        }

        // Extract liveNodes JSON string
        String liveNodes = hadoopInfo.getBeans().get(0).getLiveNodes();
        if (liveNodes == null || liveNodes.isEmpty()) {
            throw new RuntimeException("LiveNodes data is empty or null");
        }

        // Parse the liveNodes JSON string into NodeInfo object
        ObjectMapper objectMapper = new ObjectMapper();
        DataNodeInfo.NodeInfo nodeInfo;
        try {
            nodeInfo = objectMapper.readValue(liveNodes, DataNodeInfo.NodeInfo.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse liveNodes JSON", e);
        }

        return nodeInfo;
    }


}
