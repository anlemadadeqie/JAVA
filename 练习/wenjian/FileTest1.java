package wenjian;

import java.io.File;

/**
 * Created by hjh on 16-7-23.
 */
public class FileTest1 {
    public static void main(String[] args){
        File file = new File(".");
        String[] a = file.list();
        for(String ffile:a){
            System.out.println(ffile);
        }
        System.out.println("---------------");
        File[] b = file.listFiles();
        for(File ffiles:b){
            System.out.println(ffiles);
        }
    }
}
