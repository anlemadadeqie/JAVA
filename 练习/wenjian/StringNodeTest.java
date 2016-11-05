package wenjian;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Created by hjh on 16-7-23.
 */
/*使用字符串作为物理节点的字符输入/输出流的用法*/
public class StringNodeTest {
    public static void main(String[] args){
        String src="门前大桥下\n"+"啦啦啦啦啦\n"+"啊啊啊啊啊啊\n";
        char[] buffer = new char[32];
        int hasRead = 0;
        try(
                StringReader st = new StringReader(src))
        {
            while((hasRead = st.read(buffer)) > 0){
                System.out.println(new String(buffer, 0,hasRead));
            }
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
        try(StringWriter sw = new StringWriter())
        {
            sw.write("asdfgh");
            sw.write("edfghj");
            sw.write("dfghjk");
            System.out.println(sw.toString());
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
