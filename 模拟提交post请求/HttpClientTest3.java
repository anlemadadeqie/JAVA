/**
 * Created by hjh on 16-8-6.
 */


import java.io.IOException;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;

/**
 * Created by hjh on 16-8-4.
 */
public class HttpClientTest3 extends Thread{

        public HttpClientTest3(String name){
            super(name);
        }


        public void run() {
            String host = "qiandao.xiyoulinux.org";
            HttpClient client = new HttpClient();
            client.getHostConfiguration().setHost(host, 80, "http");
            HttpMethod method = null;

            if(Thread.currentThread().getName().equals("线程1")) {

                //提交post请求
                 method = getPostMethod();
                try {
                    client.executeMethod(method);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else{
                method = getPostMethod1();
                try {
                    client.executeMethod(method);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            System.out.println(method.getStatusLine());
            String response = null;
            try {
                response = new String(method.getResponseBodyAsString().getBytes("utf8"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(response);
        }


        private static HttpMethod getPostMethod(){
            PostMethod post = new PostMethod("/login1.do");
            NameValuePair[] param = {new NameValuePair("Number","04143009")};
            post.setRequestBody(param);
            post.releaseConnection();

            return post;

        }

    private static HttpMethod getPostMethod1(){
        PostMethod post = new PostMethod("/login1.do");
        NameValuePair[] param = {new NameValuePair("Number","04142051")};
        post.setRequestBody(param);
        post.releaseConnection();

        return post;

    }



}
