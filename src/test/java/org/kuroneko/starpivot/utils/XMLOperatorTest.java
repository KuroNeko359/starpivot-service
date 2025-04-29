package org.kuroneko.starpivot.utils;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class XMLOperatorTest {
    SAXReader reader;
    Document doc;
    String xmlUrl = "C:\\Users\\Administrator\\Documents\\code\\IdeaProjects\\Java\\star-pivot\\starpivot-service\\src\\test\\java\\org\\kuroneko\\starpivot\\conf\\core-site.xml";
    Element root;

    public XMLOperatorTest() throws DocumentException {
        this.reader = new SAXReader();;
        this.doc = reader.read(new File(xmlUrl));;
        this.root = doc.getRootElement();
    }

    @Test
    public void test() {
        try {


            // 删除 id=2 的节点



            addProperty("name", "value");
            addProperty("type", "string");

            removeProperty("name");

            // 保存到文件
            saveToFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private List<Element> getProperties() {
         return root.elements("property");
    }

    private void addProperty(String name, String value, String description) {
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

    private void addProperty(String name, String value) {
        addProperty(name, value, null);
    }


    private void removeProperty(String name) {
        List<Element> properties = root.elements("property");
        for (Element property : properties) {
            Element nameElem = property.element("name");
            if (nameElem.getText().equals(name)) {
                root.remove(property);
                break;
            }
        }
    }

    private void saveToFile() throws IOException {
        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter writer = new XMLWriter(new FileWriter(xmlUrl), format);
        writer.write(doc);
        writer.close();
    }
}
