package com.read;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
/**
 * dom4j解析xml的基本使用
 * 1）创建dom4j的解析器对象
 * 2）读取xxx.xml文件（url）url路径：相对路径（ClassLader：类加载器读取文件）/绝对路径
 * 3）将文档输出
 */
public class Dmo1 {
    public static void main(String[] args) throws Exception {
        /*SAXReader reader = new SAXReader();
            Document document = reader.read(url);
            return document;*/
        //1)创建dom4j的解析器对象

        SAXReader reader= new SAXReader();
        //2）读取配置文件
        /**
         * 获取Class类对象的方式
         * 1）Object.getClass()
         * 2)数据类型的.class属性
         * 3）Class.forName("全路径名称")（推荐）*/

         Document doc= reader.read(Dmo1.class.getClassLoader().getResource("contact.xml"));
         System.out.println(doc);
        //org.dom4j.tree.DefaultDocument@58372a00
        // [Document: name file:/G:/java%20project/basic_xml/target/classes/contact.xml]
    }
}
