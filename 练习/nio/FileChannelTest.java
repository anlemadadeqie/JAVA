package nio;

import java.io.*;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * Created by hjh on 16-7-26.
 */
public class FileChannelTest {
    public static void main(String[] args){
        File f = new File("./src/nio/FileChannelTest.java");

        //获得FileChannel对象
        try(FileChannel inChannel = new FileInputStream(f).getChannel();
            FileChannel outChannel = new FileOutputStream("a.txt").getChannel())
        {
            //将FileChannel里面的数据全部转换为ByteBuffer
            MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, f.length());
            //使用gbk字符集来创建解码器
            Charset charset = Charset.forName("GBK");
            outChannel.write(buffer);
            buffer.clear();
            //创建解码器对象
            CharsetDecoder decoder = charset.newDecoder();
            //使用解码器将ByteBuffer转换为CharBuffer
            CharBuffer charBuffer = decoder.decode(buffer);
            System.out.println(charBuffer);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
