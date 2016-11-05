package wenjian;

import java.io.*;

/**
 * Created by hjh on 16-7-23.
 */
public class KeyinTest {
    public static void main(String[] args){
        try(
                InputStreamReader ist = new InputStreamReader(System.in);
                BufferedReader brt = new BufferedReader(ist))
        {
            String buffer = null;
            while((buffer = brt.readLine()) != null){
                if(buffer.equals("exit")){
                    System.exit(1);
                }
                System.out.println(buffer);
            }
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
