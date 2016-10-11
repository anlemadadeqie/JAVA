package nio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by hjh on 16-7-27.
 */
public class FileTest {
    public static void main(String[] args) throws IOException {
        Files.copy(Paths.get("./src/nio/FileTest.java"),new FileOutputStream("a.txt"));
        System.out.println(Files.isHidden(Paths.get("./src/nio/FileTest.java")));
        List<String> list = Files.readAllLines(Paths.get("./src/nio/FileTest.java"), Charset.forName("gbk"));
       /* FileStore cStore = Files.getFileStore(Paths.get("C"));
        System.out.println(cStore.getTotalSpace());
        System.out.println(cStore.getUsableSpace());*/


    }
}
