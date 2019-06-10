package read;

/**
 * @Description: 读取contact.xml 遇到contact标签将标签封装Contact联系人对象
 * @Author: zdd
 * @Date: 2019/6/9
 */

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.ArrayList;
import java.util.List;

/**
 * 1)自定义类contact：联系人
 * 2）目的--->读取contact标签，封装到Contact    List<Contact>:遍历集合即可
 *           List<Element>
 *
 *  dom4j弊端：
 *           1）解析xml文件：将xml文件一次性加载，浪费空间
 *           2）当xml结构层次比较深，使用don4j解析，出现解析过程慢
 *           （内存溢出）：使用第三方jar包
 *           可以使用xpath技术解决层次结构深的问题
 *           Node node = selectSingNode("xpath表达式")
 *           List<Node> list = selectNodes("xpath表达式")
 *           举例 ：图片处理 ImageLoader
 */
public class Dom4jTest {
    public static void main(String[] args)throws Exception{
        //1)读取contact.xml文件
        Document doc =
                new SAXReader().read(Dom4jTest.class.getClassLoader().getResource("contact.xml"));
        //2)创建List集合，泛型<contact>
        List<Contact> list = new ArrayList<>();
        //3)获取所有同名的contact标签对象
        List<Element> conElem = doc.getRootElement().elements("contact");
        //遍历List<Element>获取每一个contact标签对象
        for(Element element:conElem){
            //创建联系人对象
            Contact contact = new Contact();
            //封装
            contact.setId(element.attributeValue("id"));
            contact.setName(element.elementText("name"));
            contact.setGender(element.elementText("gender"));
            contact.setPhone(element.elementText("phone"));
            contact.setEmile(element.elementText("emile"));
            contact.setAddress(element.elementText("address"));
            //添加到集合中
            list.add(contact);
        }
        //遍历集合
        for (Contact contact:list){
            System.out.println(contact);
        }
    }
}
