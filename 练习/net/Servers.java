package net;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by hjh on 16-8-10.
 */
public class Servers {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(30000);
        Socket socket = ss.accept();
        PrintStream ps = new PrintStream(socket.getOutputStream());
        ps.println("服务器的第一行数据");
        ps.print("服务器的第二行数据");
        socket.shutdownOutput();
        System.out.println(socket.isClosed());
        Scanner scan = new Scanner(socket.getInputStream());
        while(scan.hasNextLine()){
            System.out.println(scan.nextLine());
        }
        scan.close();
        socket.close();
        ss.close();
    }
}
