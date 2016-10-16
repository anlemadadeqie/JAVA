package thread;

/**
 * Created by hjh on 16-7-27.
 */
public class JoinThread extends Thread {

    public JoinThread(String name){
       super(name);
    }

    public void run(){
        for(int i = 0; i < 100; i++){
            System.out.println(getName()+""+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new JoinThread("新线程").start();
        for(int i = 0;  i < 100; i++){
            if(i == 20){
                JoinThread  it = new JoinThread("被加入的线程");
                it.start();
                it.join();
            }
            System.out.println(Thread.currentThread().getName()+""+i);
        }

    }
}
