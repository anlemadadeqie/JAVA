package wenjian;

import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;

/**
 * Created by hjh on 16-7-23.
 */
/*推回缓冲区练习*/
public class PushTest {
    public static void main(String[] args){
        try(PushbackReader pr = new PushbackReader(new FileReader("./src/wenjian/PushTest.java"),64))
        {
            char[] buf = new char[32];
            String lastContent = "";
            int hasread = 0;
            while((hasread = pr.read(buf))  > 0)
            {
                String content = new String(buf,0,hasread);
                int targetindex = 0;
                if((targetindex = (lastContent+content).indexOf("new PushbackReader")) > 0){
                    pr.unread((lastContent+content).toCharArray());
                    if(targetindex > 32){
                        buf = new char[targetindex];
                    }
                    pr.read(buf, 0, targetindex);
                    System.out.println(new String(buf,0,targetindex));
                    System.exit(0);
                }
                else{
                    System.out.println(lastContent);
                    lastContent = content;
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
