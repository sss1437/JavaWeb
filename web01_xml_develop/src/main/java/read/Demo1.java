package read;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.util.List;

/**
 * @Description:
 * @Author: zdd
 * @Date: 2019/6/9
 */
public class Demo1 {
    public static void main(String[] args)throws Exception{
        SAXReader reader= new SAXReader();
        Document doc=
                reader.read(Demo1.class.getClassLoader().getResource("contact.xml"));
        Element rootElement = doc.getRootElement();
        Element conElem = rootElement.element("contact");
        System.out.println(conElem);

        //获取所有同名的节点列表(elements("标签名称"))
        List<Element> list = (List<Element>) rootElement.elements("contact");
        for (Element element:list){
            System.out.println(element);
        }
        System.out.println("____________________");
        //elements():
        List<Element> elements = (List<Element>) rootElement.elements();
        for (Element element:elements){
            System.out.println(element);
        }

        //获取根节点下的孙标签对象
        Element nameElem  = rootElement.element("contact").element("name");
        System.out.println(nameElem);

    }
}
