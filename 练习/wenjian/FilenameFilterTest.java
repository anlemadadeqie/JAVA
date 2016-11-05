package wenjian;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Created by hjh on 16-7-23.
 */
public class FilenameFilterTest {
    public static void main(String[] args){
        File file = new File(".");
        String[] nameList = file.list(new MyFilenameFilter());
        for(String name:nameList){
            System.out.println(name);
        }

    }
}

 class MyFilenameFilter implements FilenameFilter{
     public boolean accept(File dir,String name){
         return name.endsWith(".java") || new File(name).isDirectory();
     }

 }
