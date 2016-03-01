/**
 * Created by xuemei on 16-2-20.
 */
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.sql.*;
import java.util.Iterator;


/*用dom4j对xml文件进行解析并存进数据库*/
public class ListParse2 {
    public static void main(String[] args) throws Exception {
        Connection conn = null;
        String sql;
        String url = "jdbc:mysql://localhost:3306/douban?" + "user=root&password=qweszxcsq&useUnicode=true&characterEncoding=utf8";
       try{
           Class.forName("com.mysql.jdbc.Driver");     //动态加载mysql驱动
           System.out.println("成功加载数据库驱动程序");
           conn = DriverManager.getConnection(url);
           Statement stml = conn.createStatement();


        //读取xml文件,获得Document对象,用于之后的Dom运算
        SAXReader reader = new SAXReader();
        Document document = reader.read("mybook.xml");

        //获取根节点
        Element root = document.getRootElement();

        //获得一个根节点的子节点们对象的迭代器
        Iterator it = root.elementIterator();
        while (it.hasNext()) {
            //遍历这个迭代器并把所取出来的每个对象转换为Element类型
            Element element = (Element) it.next();
            String a = element.attributeValue("Name");
            String b = element.attributeValue("address");
            String c = element.attributeValue("picture");
            String d = element.attributeValue("information");
            sql = "insert into T_book(name,address,picture,information)  values('" + a + "','" + b + "','" + c + "','" + d + "');";
            PreparedStatement pstam = conn.prepareStatement(sql);
            pstam.executeUpdate();

           /* sql = "select * from T_book;";
            ResultSet rs = stml.executeQuery(sql);
            while (rs.next()) {

                System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4));
                System.out.println();
            }*/
        }
    }catch (SQLException e) {
           System.out.println("数据库操作错误");
           e.printStackTrace();
       } catch (Exception e) {
           e.printStackTrace();
       }finally{
           conn.close();
       }
    }
}




