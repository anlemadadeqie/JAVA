package nio;

import java.nio.CharBuffer;

/**
 * Created by hjh on 16-7-26.
 */
public class BufferTest {
    public static void main(String[] args){
        //创建一个Buffer
        CharBuffer buff = CharBuffer.allocate(8);
        System.out.println(buff.capacity());
        System.out.println(buff.limit());
        System.out.println(buff.position());
        System.out.println("---------------");

        buff.put('a');
        buff.put('b');
        buff.put('c');
        System.out.println(buff.position());
        System.out.println("---------------");

        buff.flip();
        System.out.println(buff.position());
        System.out.println(buff.limit());
        System.out.println("---------------");

        buff.get();
        buff.clear();
        System.out.println(buff.position());
        System.out.println(buff.limit());
        System.out.println("---------------");



    }
}
