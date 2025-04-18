package org.kuroneko.starpivot.services.hadoop;

import org.apache.hadoop.fs.Path;
import org.kuroneko.starpivot.config.GlobalConfig;
import org.kuroneko.starpivot.entity.Property;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

@Service
public class HadoopNativeService {
    private final Logger logger = LoggerFactory.getLogger(HadoopNativeService.class);

    private String hadoopUrl;

    @Autowired
    public HadoopNativeService(GlobalConfig config) {
        hadoopUrl = config.getHadoopUrl();
    }

    @Autowired
    private RestTemplate restTemplate;

    public String getHadoopUrl() {
        return hadoopUrl;
    }

    /**
     * <p>
     * 通过Springboot的RestTemplate.连接Hadoop的jmx
     * </p>
     * <p>
     * 使用例子：
     * <code>http://../jmx?get=Hadoop:service=NameNode,name=NameNodeInfo::ClusterId"</code>
     * </p>
     * API的返回值是一个JSON，格式如下
     * <pre><code>
     *  {
     *    "beans" : [
     *      {
     *        "name":"bean-name"
     *        ...
     *      }
     *    ]
     *  }
     *  </code></pre>
     *
     * @param qry  查询的参数 值格式为Hadoop:service=NameNode
     * @param get  获取的参数 值格式为Hadoop:service=NameNode
     * @param name 名字 值格式为NameNodeInfo::ClusterId
     */
    public String getJmx(String qry, String get, String name) {
        if (qry != null) {
            qry = qry.replace("%3D","=");
            qry = qry.replace("%3d","=");
        }
        StringJoiner paramJoiner = new StringJoiner(",");
        if (qry != null) {
            paramJoiner.add("qry=" + qry);
        }
        if (get != null) {
            paramJoiner.add("get=" + get);
        }
        if (name != null) {
            paramJoiner.add("name=" + name);
        }
        String param;
        if (qry == null && get == null && name == null) {
            param = "jmx";
        } else {
            param = "jmx?" + paramJoiner;
        }
        String url = hadoopUrl + param;
        logger.info("GetJMX: {}", url);
        return restTemplate.getForObject(url, String.class);
    }

    /**
     * 获取日志
     *
     * @param filename 日志名，如果为空则返回目录
     * @return 日志内容，如果<code>filename</code>为空则返回目录
     */
    public String getLogs(String filename) {
        Path path;
        if (filename == null) {
            path = new Path("logs");
        } else {
            path = new Path("logs", filename);
        }
        URI url = new Path(hadoopUrl, path).toUri();
        logger.info("GetLogs: {}", url);
        return restTemplate.getForObject(url, String.class);
    }

    /**
     * 获取和设置日志级别
     *
     * @param className 是log的参数，但实际值为类名
     * @param level 日志等级
     * @return 页面
     */
    public String logLevel(String className, String level) {
        StringJoiner joiner = new StringJoiner("&");
        if (className != null) {
            joiner.add("log=" + className);
        }
        if (level != null) {
            joiner.add("level=" + level);
        }
        String url;
        if (className == null && level == null) {
            url = new Path(hadoopUrl, "logLevel").toUri().toString();
        } else {
            url = hadoopUrl + "logLevel?" + joiner;
        }
        logger.info("LogLevel: {}", url);
        return restTemplate.getForObject(url, String.class);
    }

    public List<Property> getConf() {
        URI uri = new Path(hadoopUrl, "conf").toUri();
        Map map = restTemplate.getForObject(uri, Map.class);
        List<Property> properties = (List<Property>) map.get("properties");
        return properties;
    }


}


