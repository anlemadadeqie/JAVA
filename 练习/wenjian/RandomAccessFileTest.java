package wenjian;


import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by hjh on 16-7-25.
 */
public class RandomAccessFileTest {
    public static void main(String[] args){
        try(RandomAccessFile raf = new RandomAccessFile("./src/wenjian/RandomAccessFileTest.java","r"))
        {
            System.out.println(raf.getFilePointer());
            raf.seek(300);
            byte[] bbuf = new byte[1024];
            int hasRead = 0;
            while((hasRead = raf.read(bbuf)) > 0){
                System.out.println(new String(bbuf,0,hasRead));
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
