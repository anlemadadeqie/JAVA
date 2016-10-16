package thread;

/**
 * Created by hjh on 16-7-27.
 */
public class SecondThread implements Runnable {
    private int i;

    public void run(){
        for(; i < 100; i++){
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
    }

    public static void main(String[] args){
        for(int i=0; i < 100; i++){
            System.out.println(Thread.currentThread().getName()+""+i);
            if(i == 20){
                SecondThread st = new SecondThread();
                new Thread(st,"one").start();
                new Thread(st,"two").start();
            }

        }
    }

}
