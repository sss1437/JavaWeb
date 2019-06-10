package sax;

/**
 * @Description:
 * @Author: zdd
 * @Date: 2019/6/10
 */

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * SAX解析xml文件（重点：事件处理方式）
 *      1）需要解析器对象：SAXParser的工厂模式
 *      2）解析xml文件
 *      3）绑定事件
 */
public class SAXDemo1 {
    public static void main(String[] args)throws Exception {

        //1)创建解析器对象
        SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
        //2)解析xml
        //SAXDemo1.class.getClassLoder().getResourceAsStream():inputStream流对象

        /**
         * 事件三要素
         *    1）事件源解析resource下的contact.xml
         *    2)事件监听器：编写一个事件处理程序DefaultHandler
         *         自定义一个类继承DefaultHandler，重写方法
         *         遇到开始标签触发一个方法，遇到文本内容触发一个方法，遇到结束标签触发方法
         *    3)绑定事件监听器：new MyDefaultHandler1()
         */
        parser.parse(SAXDemo1.class.getClassLoader()
                .getResourceAsStream("contact.xml"), new MyDefaultHandler1());

    }
}
