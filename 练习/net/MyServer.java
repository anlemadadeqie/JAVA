package net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by hjh on 16-8-9.
 */
public class MyServer {
    public static ArrayList<Socket> socketList = new ArrayList<>();
    public static  void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(30000);
        while(true){
            Socket socket = ss.accept();
            socketList.add(socket);
            new Thread(new ServerThread(socket)).start();
        }
    }
}
