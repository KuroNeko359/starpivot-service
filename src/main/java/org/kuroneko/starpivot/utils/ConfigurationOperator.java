package org.kuroneko.starpivot.utils;

import org.apache.hadoop.yarn.webapp.NotFoundException;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * XML 配置文件操作工具类，提供对 XML 格式配置文件的属性增删查改及持久化功能
 *
 * <p>通过本工具类可执行以下操作：
 * <ul>
 *   <li>添加包含 name/value/description 的 XML 属性节点</li>
 *   <li>根据属性名删除指定 XML 节点</li>
 *   <li>获取当前 XML 文件中的所有属性节点</li>
 *   <li>将内存中的 XML 修改持久化到文件系统</li>
 * </ul>
 *
 * @author KuroNeko359
 */
public class ConfigurationOperator {
    SAXReader reader;
    Document doc;
    String xmlUrl = null;
    Element root;

    /**
     * 构建 XML 配置文件操作器
     *
     * @param xmlUrl XML 配置文件路径（需包含完整文件名）
     * @throws DocumentException        当文件读取失败或 XML 格式错误时抛出
     * @throws IllegalArgumentException 当文件路径为空或文件不存在时抛出
     */
    public ConfigurationOperator(String xmlUrl) throws DocumentException {
        this.xmlUrl = xmlUrl;
        this.reader = new SAXReader();
        this.doc = reader.read(new File(xmlUrl));
        this.root = doc.getRootElement();
    }

    /**
     * 获取当前 XML 文件中所有属性节点
     *
     * <p>返回的节点列表包含完整的属性结构：
     * <pre>{@code
     * <property>
     *   <name>sample</name>
     *   <value>test</value>
     *   <description>示例属性</description>
     * </property>
     * }</pre>
     *
     * @return 属性节点列表（可能为空列表）
     */
    public List<Element> getProperties() {
        return root.elements("property");
    }

    /**
     * 添加完整属性节点（包含描述信息）
     *
     * @param name        属性名称（非空时创建 name 子节点）
     * @param value       属性值（非空时创建 value 子节点）
     * @param description 属性说明（非空时创建 description 子节点）
     */
    public void addProperty(String name, String value, String description) {
        Element element = root.addElement("property");
        if (name != null) {
            element.addElement("name").setText(name);
        }
        if (value != null) {
            element.addElement("value").setText(value);
        }
        if (description != null) {
            element.addElement("description").setText(description);
        }
    }

    /**
     * 添加基本属性节点（不包含描述信息）
     *
     * @param name  属性名称（非空时创建 name 子节点）
     * @param value 属性值（非空时创建 value 子节点）
     */
    public void addProperty(String name, String value) {
        addProperty(name, value, null);
    }

    /**
     * 删除指定名称的属性节点
     *
     * <p><b>注意：</b>当存在多个同名属性时，只会删除第一个匹配项</p>
     *
     * @param name 要删除的属性名称（不允许为空）
     * @throws NullPointerException 当 name 参数为 null 时抛出
     */
    public void removeProperty(String name) {
        Element property = findProperty(name);
        root.remove(property);
    }

    /**
     * 将内存中的 XML 修改持久化到文件系统
     *
     * <p><b>重要：</b>所有内存操作必须调用本方法才能生效</p>
     * <p>使用格式化输出保持 XML 可读性，字符编码采用系统默认设置</p>
     *
     * @throws IOException           当文件写入失败时抛出
     * @throws IllegalStateException 当文件路径未初始化时抛出
     */
    public void saveToFile()
            throws IOException {
        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter writer = new XMLWriter(new FileWriter(xmlUrl), format);
        writer.write(doc);
        writer.close();
    }

    /**
     * 根据名称找到Property
     *
     * @param name property的名称
     * @return property的Element
     * @exception NotFoundException 如果没有根据名字找到节点 那么抛出这个异常
     */
    public Element findProperty(String name) {
        List<Element> properties = root.elements("property");
        for (Element property : properties) {
            Element nameElem = property.element("name");
            if (nameElem.getText().equals(name)) {
                return property;
            }
        }
        throw new NotFoundException("Property not found");
    }
}



