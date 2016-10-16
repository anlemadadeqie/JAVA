package thread;

/**
 * Created by hjh on 16-8-2.
 */
/*中断线程
* interrupt()只是设置中断状态提示线程该中断了，并没有真正中断线程，线程内部自己中断
* 自定义标记完成中断线程*/
public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
//        MyThread my = new MyThread();
//        Thread thread = new Thread(my);
//        thread.start();
//        for(int i=0; i< 10; i++){
//            System.out.println("main"+i);
//            if(i == 5){
//                thread.interrupt();  //设置中断状态为true
//            }
//            Thread.sleep(1000);
//        }
        MyThread my = new MyThread();
        MyThread1 my1 = new MyThread1();
        Thread thread = new Thread(my,"t1");
        Thread thread1 = new Thread(my1,"t2");
        thread.start();
        thread1.start();
        for(int i=0; i< 10; i++){
            System.out.println("main"+i);
            if(i == 5){
                //thread.interrupt();  //设置中断状态为true
                my1.setFlag(false);
            }
            Thread.sleep(1000);
        }
    }
}

class MyThread implements Runnable{

    @Override
//    public void run() {
//        for(int i = 0; i < 10; i++){
//            System.out.println(Thread.currentThread().getName()+i);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//    }
//    public void run() {
//        int i = 0;
//        while(!Thread.interrupted()){
//            System.out.println(Thread.currentThread().getName()+i);
//            i++;
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//                Thread.currentThread().interrupt();
//            }
//        }
//
//    }
    public void run() {
        for(int i = 0; i < 10; i++){
            System.out.println(Thread.currentThread().getName()+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class MyThread1 implements Runnable{
    private boolean flag = true;

    public boolean isFlag(){
        return flag;
    }

    public void setFlag(boolean flag){
        this.flag = flag;
    }
    @Override
        public void run() {
            int   i = 0;
            while(flag){
                System.out.println(Thread.currentThread().getName()+i);
                i++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
}
