package thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

/**
 * Created by hjh on 16-8-8.
 */
/*将一个任务分成多个小任务多核并行处理*/

class PrintTask extends RecursiveAction{

    private static final int THRESHOLD = 50;
    private int start;
    private int end;

    //打印从start到end的任务
    public PrintTask(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if(end - start < THRESHOLD){
            for(int i = start; i < end; i++){
                System.out.println(Thread.currentThread().getName()+""+"是"+""+i);
            }
        }
        else{
            int middle = (start + end)/2;
            PrintTask left = new PrintTask(start, middle);
            PrintTask right = new PrintTask(middle, end);
            left.fork();
            right.fork();
        }

    }
}


public class ForkJoinPoolTest {
    public static void main(String[] args) throws InterruptedException {
        ForkJoinPool pool = new ForkJoinPool();

        //提交可分解的printtask任务
        pool.submit(new PrintTask(0, 300));
        pool.awaitTermination(2, TimeUnit.SECONDS);

        //关闭线程池
        pool.shutdown();
    }
}
