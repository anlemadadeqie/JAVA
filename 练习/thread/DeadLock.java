package thread;

/**
 * Created by hjh on 16-8-1.
 */
/*死锁*/
class A{
    public synchronized void foo(B b){
        System.out.println("当前线程名："+Thread.currentThread().getName()+"进入了Ａ实例的fool方法");
        try{
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("当前线程名"+Thread.currentThread().getName()+"企图调用Ｂ实例的last方法");
        b.last();
    }

    public synchronized void last(){
        System.out.println("进入了a类的last方法内部");
    }
}

class B{
    public synchronized void bar(A a){
        System.out.println("当前线程名"+Thread.currentThread().getName()+"进入了b的bar方法");
        try{
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("当前线程名"+Thread.currentThread().getName()+"企图调用Ａ的实例方法");
        a.last();
    }

    public synchronized void last(){
        System.out.println("进入了b类的last方法内部");
    }
}
public class DeadLock implements Runnable{
    A a = new A();
    B b = new B();
    public void init(){
        Thread.currentThread().setName("主线程");
        a.foo(b);
        System.out.println("进入了主线程之后");
    }

    public void run(){
        Thread.currentThread().setName("副线程");
        b.bar(a);
        System.out.println("进入了副线程之后");
    }

    public static void main(String[] args){
        DeadLock d1 = new DeadLock();
        new Thread(d1).start();
        d1.init();
    }
}
