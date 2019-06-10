package write;


import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;

/**
 * @Description:
 * document对象输出到硬盘上，目的：修改删除标签/属性
 * @Author: zdd
 * @Date: 2019/6/10
 */


public class Demo2 {

    public static void main(String[] args) throws Exception {
        //add();
        //editor();
        //删除节点
        Document doc =
                new SAXReader().read(Demo2.class.getClassLoader().getResource("contact.xml"));


        //将id=“002”的contact标签删除
        //xpath表达式
        Element element = (Element) doc.selectSingleNode("//contact[@id='002']");
       element.detach();
        OutputStream out = new FileOutputStream("e:/contact.xml");
        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter writer = new XMLWriter(out,format);
        writer.write(doc);
        writer.close();

    }

    //创建空文档/添加节点/属性文本
    public static void add() throws IOException{
        //1)add添加文档
        // 创建一个空文档
        Document doc = DocumentHelper.createDocument();
        //创建节点
        Element element = doc.addElement("contact-list");
        Element contactElem = element.addElement("contact");
        contactElem.addAttribute("id","001");

        OutputStream out = new FileOutputStream("e:/contact.xml");
        XMLWriter writer = new XMLWriter(out);
        writer.write(doc);
        writer.close();
    }

    public static void editor()throws Exception{
        //修改 标签的属性/修改文本内容
        Document doc =
                new SAXReader().read(Demo2.class.getClassLoader().getResource("contact.xml"));
        //修改标签的属性
        Element conElem = doc.getRootElement().element("contact");
        Attribute attribute = conElem.attribute("id");
        attribute.setValue("003");

        Element genElem = conElem.element("gender");
        genElem.setText("女");


        OutputStream out = new FileOutputStream("e:/contact.xml");
        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter writer = new XMLWriter(out,format);
        writer.write(doc);
        writer.close();
    }

}
