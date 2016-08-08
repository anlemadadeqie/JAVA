/**
 * Created by xuemei on 16-1-25.
 */
import java.io.*;
import java.beans.XMLEncoder;

/*将一个java对象转化为XML格式*/
public class ChangeXml {
    public static void changeXml(Customer obj) throws FileNotFoundException,IOException,Exception {
        File outfile = new File("Customer.xml");
        if (!outfile.exists()) {
            System.out.println("该文件不存在!");
        }
        //创建文件输出流
        FileOutputStream outfile1 = new FileOutputStream(outfile);
        //创建XML文件对象的输出类实例
        XMLEncoder encoder = new XMLEncoder(outfile1);
        //对象序列化输出到XML文件
        encoder.writeObject(obj);
        encoder.flush();
        encoder.close();
        outfile1.close();

    }

    public static void main(String[] args)throws Exception{
        Customer customer = new Customer();
        customer.setName("孙悟空");
        customer.setAge(100);
        customer.setId(1);
        changeXml(customer);
    }
}


