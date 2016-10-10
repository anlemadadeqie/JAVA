package net;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * Created by hjh on 16-8-11.
 */
public class NClient {
    private Selector selector = null;
    static final int PORT = 30000;

    //定义实现编码，解码的字符集对象
    private Charset charset = Charset.forName("UTF-8");

    //客户端sockchannel
    private SocketChannel sc = null;

    public void init() throws IOException {
        selector = Selector.open();

        InetSocketAddress isa = new InetSocketAddress("127.0.0.1",PORT);
        //连接到指定的主机和端口
        sc = SocketChannel.open(isa);
        sc.configureBlocking(false);
        sc.register(selector, SelectionKey.OP_READ);
        new ClientThreads().start();

        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            sc.write(charset.encode(line));

        }

    }


    private class ClientThreads extends Thread{
        public void run(){
            try{
                while(selector.select() > 0){
                    for(SelectionKey sk : selector.selectedKeys()){
                        selector.selectedKeys().remove(sk);
                        if(sk.isReadable()){
                            //使用nio读取channel中的数据
                            SocketChannel sc = (SocketChannel)sk.channel();
                            ByteBuffer buff = ByteBuffer.allocate(1024);
                            String content = "";
                            while(sc.read(buff) > 0){
                                sc.read(buff);
                                buff.flip();
                                content += charset.decode(buff);
                            }
                            System.out.println("聊天信息:"+content);
                            sk.interestOps(SelectionKey.OP_READ);
                        }

                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new NClient().init();

    }
}
