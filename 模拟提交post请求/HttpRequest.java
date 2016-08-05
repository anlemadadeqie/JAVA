import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by hjh on 16-8-3.
 */
public class HttpRequest {
    public static String sendPost(String url,String param){
        PrintWriter out = null;
        BufferedReader in = null;
        String result="";
        try{
            URL realurl = new URL(url);

            //打开和url之间的连接
            URLConnection conn = realurl.openConnection();

            //设置通用的请求属性
            conn.setRequestProperty("accept","*/*");
            conn.setRequestProperty("connection","Keep-Alive");
            conn.setRequestProperty("user-agent","Mozilla/4.0(compatible;MSIE 6.0;Windows NT 5.1;SV1)");

            //发送post请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);

            //获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            //发送请求参数
            out.print(param);
            //flush输出流的参数
            out.flush();
            //定义bufferReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while((line = in.readLine()) != null){
                result += line;
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try{
                if(out != null){
                    out.close();
                }
                if(in != null){
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static void main(String[] args){
        String sr = HttpRequest.sendPost("http://182.254.243.29:8080/qiandao/login1.do","key=04143009");
        System.out.println(sr);

    }
}
