import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class JsoupTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[] information = new String[600];
        String[] Name = new String[300];
        int j=0,k=0,h=0;
        for(int i =0;i<10;i++)
        {
            j=i*25;
            String urt = "http://book.douban.com/top250?start="+j;
            Document doc=null;
            try {
                doc = Jsoup.connect(urt).get();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            Elements ListDiv1 = doc.getElementsByAttributeValue("class","pl");
            for (Element element :ListDiv1) {

                information[k]=element.html();
                k++;
            }
            Elements ListDiv = doc.getElementsByAttributeValue("class","pl2");
            for (Element element :ListDiv) {
                Elements links = element.getElementsByTag("a");
                for (Element link : links) {

                    String linkText = link.text().trim();
                    Name[h]=linkText;
                    h++;
                }
            }
        }
        j =0;
        for(int i = 0;i<500;i++)
        {

            information[j]=information[i]+information[++i];
            j++;
        }
        XMLWrite dom4j=new XMLWrite();
        dom4j.generateDocument(Name, information);
    }

}