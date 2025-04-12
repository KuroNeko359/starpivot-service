package org.kuroneko.starpivot.hadoop;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import org.apache.hadoop.fs.Path;
import org.junit.jupiter.api.Test;
import org.apache.hadoop.jmx.JMXJsonServlet;
import org.kuroneko.starpivot.config.GlobalConfig;
import org.mockito.Mockito;

import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;


public class OverviewTest {

    @Test
    public void test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, MalformedObjectNameException, IOException {
        OverviewTest overviewTest = new OverviewTest();
        JMXJsonServlet jmxJsonServlet = new JMXJsonServlet();
        Class<?> clazz = jmxJsonServlet.getClass();
        Method method = clazz.getDeclaredMethod("listBeans", JsonGenerator.class, ObjectName.class, String.class, HttpServletResponse.class);
        method.setAccessible(true);
// 准备测试数据
        ObjectName objectName = new ObjectName("java.lang:type=Memory"); // 示例MBean
        String path = "/memory";

        // 创建JSON生成器（输出到内存）
        StringWriter jsonOutput = new StringWriter();
        JsonGenerator generator = new JsonFactory().createGenerator(jsonOutput);

        // 模拟HttpServletResponse
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);

        try {
            // 执行被测试方法
            method.invoke(jmxJsonServlet, generator, objectName, path, response);

            // 验证响应状态码
            Mockito.verify(response).setStatus(HttpServletResponse.SC_OK);

            // 获取生成的JSON内容
            generator.flush();
            String resultJson = jsonOutput.toString();

            // 添加具体的断言（示例）
            // assertNotNull(resultJson);
            // assertTrue(resultJson.contains("java.lang:type=Memory"));
        } finally {
            generator.close();
            jsonOutput.close();
        }
    }

    @Test
    public void pathTest() throws MalformedURLException, URISyntaxException {
        String hadoopUrl = "http://hadoop102:9870/";
        URI uri = new Path(hadoopUrl, "memory").toUri();
        System.out.println(uri);
    }
}
