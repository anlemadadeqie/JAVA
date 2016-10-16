package thread;

/**
 * Created by hjh on 16-7-27.
 */
/*通过继承Thread类来创建线程*/
public class FirstThread extends Thread{
    private int i;
    public void run(){
        for(; i < 100; i++){
            System.out.println(getName()+i);
        }
    }

    public static void main(String[] args){
        for(int i = 0; i < 100; i++){
            System.out.println(Thread.currentThread().getName()+i);
            if(i == 20){
                new FirstThread().start();
                new FirstThread().start();
            }
        }
    }

}
