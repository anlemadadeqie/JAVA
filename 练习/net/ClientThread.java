package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by hjh on 16-8-9.
 */
public class ClientThread implements  Runnable{

    private Socket s;

    BufferedReader br = null;

    public ClientThread(Socket s) throws IOException {
        this.s = s;
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));

    }

    @Override
    public void run() {
        try{
            String content = null;
            while((content = br.readLine()) != null){
                System.out.println(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
