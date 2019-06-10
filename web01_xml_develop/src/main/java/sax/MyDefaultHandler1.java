package sax;

import org.apache.xpath.operations.String;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @Description:
 * @Author: zdd
 * @Date: 2019/6/10
 */
public class MyDefaultHandler1 extends DefaultHandler {

    /**
     *文档开始方法
     */

    @Override
    public void startDocument() throws SAXException {
        System.out.println("MyDefaultHandler1.starDocument,文档开始了");
    }

    /**
     *遇到开始标签触发
     * @param qName:标签名称
     * @param attributes：属性列表
     * @throws SAXException
     */
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("MyDefaultHandler1.starElement,开始标签"+qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("MyDefaultHandler1.characters，文本内容");
    }

    //结束标签:</标签名称>
    @Override
    public void endElement(java.lang.String uri, java.lang.String localName, java.lang.String qName) throws SAXException {
        System.out.println("MyDefaultHandler1.endElement,结束标签名称"+qName);
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("MyDefaultHandler1.endDocument,文档结束了");
    }
}
