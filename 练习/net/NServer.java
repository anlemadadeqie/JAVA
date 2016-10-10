package net;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;

/**
 * Created by hjh on 16-8-10.
 */
public class NServer {

    //用来检测所有channel状态的selector
    private Selector selector = null;
    static final int PORT = 30000;

    //定义实现编码，解码的字符集对象
    private Charset charset = Charset.forName("UTF-8");

    public void init() throws IOException{
        selector = Selector.open();

        //通过open方法来打开一个未绑定的ServerSocketChannel实例
        ServerSocketChannel server = ServerSocketChannel.open();
        InetSocketAddress inet = new InetSocketAddress("127.0.0.1",PORT);
        server.bind(inet);

        //设置该Serversocket以非阻塞方式工作
        server.configureBlocking(false);

        //将该ServerSocket注册到selector上
        server.register(selector, SelectionKey.OP_ACCEPT);

        //判断该selector上的是否有io操作
        while((selector.select()) > 0){

            //对该selector上的需要进io操作的通道进行遍历，做出相应处理
            for(SelectionKey sk : selector.selectedKeys()){
                selector.selectedKeys().remove(sk);
                if(sk.isAcceptable()){

                    //调用accept方法接受连接，产生服务器端的socketChannel
                    SocketChannel sc = server.accept();
                    sc.configureBlocking(false);
                    sc.register(selector, SelectionKey.OP_READ);
                    sk.interestOps(SelectionKey.OP_ACCEPT);
                }

                //如果该通道有需要读取的数据
                if(sk.isReadable()){

                    //获取该SelectionKey对应的channel,该channel中有可读的数据
                    SocketChannel sc = (SocketChannel)sk.channel();
                    //定义准备执行读取数据的ByteBuffer
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    String content="";
                    try{
                        while(sc.read(buffer) > 0){
                            buffer.flip();
                            content += charset.decode(buffer);

                        }
                        System.out.println("读取的数据"+content);
                        sk.interestOps(SelectionKey.OP_READ);
                    }catch (IOException ex){
                        sk.cancel();
                        if(sk.channel() != null){
                            sk.channel().close();
                        }
                    }

                    if(content.length() > 0){
                        for(SelectionKey key : selector.selectedKeys()){
                            //获取该key对应的channel
                            Channel targetChannel = key.channel();
                            //如果该channel是SocketChannel对象
                            if(targetChannel instanceof SocketChannel){
                                //将读到的内容写入该channel中
                                SocketChannel dest = (SocketChannel)targetChannel;
                                dest.write(charset.encode(content));
                            }

                        }
                    }

                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        new NServer().init();
    }

}
