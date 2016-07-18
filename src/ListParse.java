/**
 * Created by xuemei on 16-1-25.
 */
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import java.util.Iterator;


/*用dom4jIterator迭代器的方式对xml文件进行解析*/
public class ListParse {
    public static void main(String[] args) throws Exception {
        //读取xml文件,获得Document对象,用于之后的Dom运算
        SAXReader reader = new SAXReader();
        Document document = reader.read("t.xml");

        //获取根节点
        Element root = document.getRootElement();

        //获得一个根节点的子节点们对象的迭代器
        Iterator it = root.elementIterator();
        while (it.hasNext()) {
            //遍历这个迭代器并把所取出来的每个对象转换为Element类型
            Element element = (Element) it.next();
            Iterator elelt = element.elementIterator();
            while (elelt.hasNext()) {
                Element e = (Element) elelt.next();
                //输出标签名和标签名间的数据
                System.out.println(e.getName() + ":" + e.getText());
            }
            System.out.println();
        }
    }
}


