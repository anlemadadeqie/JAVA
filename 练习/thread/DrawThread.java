package thread;

/**
 * Created by hjh on 16-7-27.
 */
/*public class DrawThread extends Thread{
    private Account account;
    private double drawAmount; //所取的钱数

    public DrawThread(String name, Account account, double drawAmount){
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;

    }

    public void run(){
        if(account.getBalance() >= drawAmount){
            System.out.println(getName()+"取钱成功");
            try{
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            account.setBalance(account.getBalance()-drawAmount);
            System.out.println(account.getBalance());

        }
        else{
            System.out.println(getName()+"余额不足");
        }
    }
}*/

public class DrawThread extends Thread{
    private Account account;
    private double drawAmount;

    public DrawThread(String name,Account account, double drawAmount){
        super(name);
        this.account  = account;
        this.drawAmount = drawAmount;
    }

    public void run(){
        synchronized (account){
            if(account.getBalance() >= drawAmount){
                System.out.println(getName()+"取钱成功");
                try{
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                account.setBalance(account.getBalance()-drawAmount);
                System.out.println(account.getBalance());

            }
            else{
                System.out.println(getName()+"余额不足");
            }
        }
    }
}
