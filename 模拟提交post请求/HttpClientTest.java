

import java.io.IOException;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;

/**
 * Created by hjh on 16-8-4.
 */
public class HttpClientTest {
    public static void myPost() throws IOException {
        HttpClient client = new HttpClient();
        client.getHostConfiguration().setHost("182.254.243.29", 8080, "http");

        //提交post请求
        HttpMethod method = getPostMethod();
        client.executeMethod(method);

        System.out.println(method.getStatusLine());
        String response = new String(method.getResponseBodyAsString().getBytes("8859_1"));
        System.out.println(response);
        method.releaseConnection();

    }

    private static HttpMethod getPostMethod(){
        PostMethod post = new PostMethod("/qiandao/login1.do");
        NameValuePair  number = new NameValuePair("Number","04143009");
        post.setRequestBody(new NameValuePair[]{number});
        return post;

    }
}
