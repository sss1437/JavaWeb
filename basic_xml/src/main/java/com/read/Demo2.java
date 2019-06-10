package com.read;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

/**
 * @Description:
 * @Author: zdd
 * @Date: 2019/6/9
 */
public class Demo2 {
    public static void main(String[] args)throws Exception{
        //1)创建解析器对象
        SAXReader reader = new SAXReader();

        //2)读取文件
        //xml document
        Document doc = reader.read(Demo2.class.getClassLoader().getResource("contact.xml"));

        //3)获取跟标签
        Element rootElem = doc.getRootElement();

        //获取标签的名称
        System.out.println(rootElem.getName());

        //4）获取子标签getElement("标签名称"):默认获取第一个子标签
        Element conElem = rootElem.element("contact");
        System.out.println(conElem);
        System.out.println("____________________");
        //5)获取所有的同名的子节点列表
        List<Element> list = rootElem.elements("contact");
        /**
         * 集合遍历
         * for-each
         * for
         * 迭代器
         */

        for (Element element:list){
            System.out.println(element);
        }
    }
}
