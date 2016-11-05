package wenjian;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.File;
import java.io.IOException;
import java.net.SocketPermission;

/**
 * Created by hjh on 16-7-23.
 */
public class FileTest {
    public static void main(String[] args)throws IOException{
        File file = new File(".");
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getAbsoluteFile().getParent());


        File tmpfile = File.createTempFile("aaa",".txt",file);
        tmpfile.deleteOnExit();

        File newfile = new File(System.currentTimeMillis()+"");
        System.out.println(newfile.exists());

        newfile.createNewFile();
        newfile.mkdir();

        String[] filelist = file.list();
        for(String filename : filelist){
            System.out.println(filename);
        }

        File[] roots = File.listRoots();
        for(File root:roots){
            System.out.println(root);
        }



    }
}
