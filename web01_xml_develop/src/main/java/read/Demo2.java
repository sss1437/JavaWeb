package read;

/**
 * @Description:
 * 使用dom4j获取属性对象
 * 通过dom4j获取标签的文本内容
 * @Author: zdd
 * @Date: 2019/6/9
 */


import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 获取属性的前提，获取属性对应的标签对象
 */
public class Demo2 {
    public static void main(String[] args)throws Exception{
        //获取document对象
        SAXReader reader= new SAXReader();
        Document doc=
                reader.read(Demo1.class.getClassLoader().getResource("contact.xml"));

        //需求id=“001”属性值
        //获取contact标签对象
        //方式一：通过属性名称获取值
        Element conElem = doc.getRootElement().element("contact");
        String value = conElem.attributeValue("id");
        System.out.println("id = "+value);
        System.out.println("__________________");

        //方式2：通过属性对象获取属性名称和属性值
        //getName():获取属性名称   getValue()：获取属性值
        Attribute attr = conElem.attribute("id");
        String idName = attr.getName();
        String idValue = attr.getValue();
        System.out.println(idName+"="+idValue);



        /**
         * 包含空格和换行
         *
         * 获取文本内容，前提是获取文本内容对应的标签对象
         */

        //1)获取第一个标签的name的文本内容
        Element nameElem = doc.getRootElement().element("contact").element("name");
        String text1 = doc.getRootElement().getText();
        System.out.println(text1);
        //2)方式一：通过标签对象.getText()
        String text = nameElem.getText();
        System.out.println(text);
        System.out.println("__________________");

        //方式2：通过父标签对象.elementText("子节点名称")：获取子节点的文本内容
        String name = conElem.elementText("name");
        String gender = conElem.elementText("gender");
        String phone = conElem.elementText("phone");
        System.out.println(name+" "+gender+" "+phone);
    }
}
