package thread;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by hjh on 16-7-27.
 */
public class ThirdThread implements Callable<Integer>{

    public Integer call(){
        int i = 0;
        for(; i < 100; i++){
            System.out.println(Thread.currentThread().getName()+""+i);
        }

        return i;

    }

    public static void main(String[] args){
        ThirdThread tr = new ThirdThread();
        FutureTask<Integer> task = new FutureTask<Integer>(tr);
        for(int i = 0; i < 100; i++){
            System.out.println(Thread.currentThread().getName()+""+i);
            if(i == 20){
                new Thread(task, "有返回值的线程").start();
            }
        }
        try{
            System.out.println("子线程的返回值"+task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
