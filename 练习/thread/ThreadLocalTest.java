package thread;

/**
 * Created by hjh on 16-8-8.
 */
/*使用threadlocal实现线程的并发访问*/

class Accounts{
    /*定义一个线程局部变量*/
    private ThreadLocal<String> name = new ThreadLocal<>();

    public Accounts(String str){
        this.name.set(str);
        System.out.println("---"+this.name.get());

    }

    public String getName(){
        return name.get();
    }

    public void setName(String str){
        this.name.set(str);
    }



}

class MyTest extends Thread{
    private Accounts account;
    public MyTest(Accounts account, String name){
        super(name);
        this.account = account;
    }

    public void run(){
        for(int i = 10; i < 10; i++){
            if(i == 6){
                account.setName(getName());
            }
            System.out.println(account.getName()+"账户的值"+i);
        }
    }
}


public class ThreadLocalTest{
    public static void main(String[] args){
        Accounts at = new Accounts("初始名");

        new MyTest(at,"线程甲").start();
        new MyTest(at,"线程乙").start();
    }

}



