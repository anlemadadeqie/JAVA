package wenjian;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by hjh on 16-7-25.
 */
/*读取其它进程的输出信息*/
public class ReadFromProcess {
    public static void main(String[] args)throws IOException{
        //运行javac命令，返回运行该命令的子进程
        Process p = Runtime.getRuntime().exec("javac");
        try(BufferedReader br = new BufferedReader(new InputStreamReader(p.getErrorStream())))
        {
            String buff = null;
            while((buff = br.readLine()) != null){
                System.out.println(buff);
            }

        }
    }
}
