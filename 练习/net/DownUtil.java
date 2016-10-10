package net;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by hjh on 16-8-8.
 */

/*实现一个多线程下载工具类*/
public class DownUtil {

    //定义下载资源的路径
    private String path;

    //定义所下载文件的保存位置
    private String targetFile;

    //定义需要使用多少个线程下载资源
    private int threadNum;

    //定义下载的线程对象
    private DownThread[] threads;

    //定义下载的文件的总大小
    private int fileSize;

    public DownUtil(String path, String targetFile, int threadNum) {
        this.path = path;
        this.threadNum = threadNum;
        threads = new DownThread[threadNum];
        this.targetFile = targetFile;
    }

    public void download() throws Exception {
        URL url = new URL(path);
        //与path建立远程连接
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5 * 1000); //设定连接超时
        conn.setRequestMethod("GET");   //设置url的请求方法
        //
        conn.setRequestProperty("Accept", "image/gif,image/jpeg,image/pjpeg,image/pjpeg," + "application/x-shockwave-flash,application/xaml+xml," + "application/vnd.ms-xpsdocument,application/x-ms-xbap," + "application/x-ms-application,application/vnd.ms-excel," + "application/vnd.ms-powerpoint,application/msword,*/*");
        conn.setRequestProperty("Accept-Language", "zh-CN");
        conn.setRequestProperty("charset", "UTF-8");
        conn.setRequestProperty("Connection", "Keep-Alive");

        fileSize = conn.getContentLength();
        conn.disconnect();
        int currentPartSize = fileSize / threadNum + 1;
        RandomAccessFile file = new RandomAccessFile(targetFile, "rw");
        file.setLength(fileSize);
        file.close();

        for (int i = 0; i < threadNum; i++) {
            //计算每个线程下载的开始位置
            int startPos = i * currentPartSize;
            //每个线程使用一个randomaccessfile进行下载
            RandomAccessFile currentPart = new RandomAccessFile(targetFile, "rw");
            currentPart.seek(startPos);
            threads[i] = new DownThread(startPos, currentPartSize, currentPart);
            //启动下载线程
            threads[i].start();

        }
    }

    public double getCompleteRate() {
        //统计多个线程已经下载的总大小
        int sumSize = 0;
        for (int i = 0; i < threadNum; i++) {
            sumSize += threads[i].length;
        }

        //返回已经完成的百分比
        return sumSize * 1.0 / fileSize;
    }

    private class DownThread extends Thread {
        //当前线程的下载位置
        private int startPos;
        //定义当前线程负责下载的文件大小
        private int currentPartSize;
        //当前线程需要下载的文件块
        private RandomAccessFile currentPart;
        //定义该线程已下载的字节数
        public int length;

        public DownThread(int startPos, int currentPartSize, RandomAccessFile currentPart) {
            this.startPos = startPos;
            this.currentPartSize = currentPartSize;
            this.currentPart = currentPart;
        }

        public void run() {
            try {
                URL url = new URL(path);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setConnectTimeout(5 * 1000);
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept", "image/gif,image/jpeg,image/pjpeg,image/pjpeg," + "application/x-shockwave-flash,application/xaml+xml," + "application/vnd.ms-xpsdocument,application/x-ms-xbap," + "application/x-ms-application,application/vnd.ms-excel," + "application/vnd.ms-powerpoint,application/msword,*/*");
                conn.setRequestProperty("Accept-Language", "UTF-8");
                InputStream inStream = conn.getInputStream();
                //跳过startpos个字节，表明该线程只下载自己负责的那部分文件
                inStream.skip(this.startPos);
                byte[] buffer = new byte[1024];
                int hasRead = 0;
                //读取网络数据，并写入本地文件
                while (length < currentPartSize && (hasRead = inStream.read(buffer)) != -1) {
                    currentPart.write(buffer, 0, hasRead);
                    length += hasRead;
                }
                currentPart.close();
                inStream.close();

            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

    }
}
