import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import java.io.*;

public class XMLWrite{
    public void generateDocument(String[]Name,String[] information ){
        Document document = DocumentHelper.createDocument();
        Element catalogElement = document.addElement("TOP250book");
        for(int i=0;i<250;i++)
        {
            String t = "Top"+(i+1);
            Element journalElement =  catalogElement.addElement(t);
            journalElement.addAttribute("Name", Name[i]);
            journalElement.addAttribute("information", information[i]);
        }
        try{
            OutputFormat format = OutputFormat.createPrettyPrint();
            format.setEncoding("UTF-8");
            XMLWriter output = new XMLWriter(new FileOutputStream( new File("mybook.xml")),format);
            output.write(document);
            output.close();
        }
        catch(IOException e){System.out.println(e.getMessage());}
    }
}