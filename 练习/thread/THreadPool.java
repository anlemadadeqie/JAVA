package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by hjh on 16-8-8.
 */
/*利用线程池执行线程指定任务*/
class MyThreads implements Runnable{

//    public MyThreads(String name){
//       super(name);
//    }


    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            System.out.println(Thread.currentThread().getName()+""+i);
        }

    }
}

public class THreadPool {
    public static void main(String[] args)throws Exception{
        //  创建一个可重用具有固定数量的线程池
        ExecutorService pool = Executors.newFixedThreadPool(6);
        pool.submit(new MyThreads());
        pool.submit(new MyThreads());
        pool.shutdown();

    }
}
