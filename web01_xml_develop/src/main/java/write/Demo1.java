package write;


import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * @Description:将document从内存输出到硬盘上并且携带指定文件
 * @Author: zdd
 * @Date: 2019/6/10
 */
public class Demo1 {
    public static void main(String[] args)throws Exception{
         //1)读contact.xml
        Document doc = new SAXReader().read(Demo1.class.getClassLoader().getResource("contact.xml"));

        //使用XMLWrite对象
        OutputStream out = new FileOutputStream("e:/contact.xml");
        /**
         * 输出的细节：OutputFormat对象：指定xml文件的输出格式
         */
        //紧凑格式：部署上线：xml文件都会在一行，节省xml文件空间createCompactFormat()
        //优雅格式：测试时使用（默认的）createPrettyPrint()
        OutputFormat format = OutputFormat.createCompactFormat();
        //设置输出编码
        format.setEncoding("utf-8");

        XMLWriter writer = new XMLWriter(out,format);
        //将doc对象写出到硬盘
        writer.write(doc);
        //释放资源
        writer.close();

    }
}
