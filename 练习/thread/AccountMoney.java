package thread;

/**
 * Created by hjh on 16-8-1.
 */
public class AccountMoney {
    private String accountNo;
    private double balance;

    private boolean flag = false;
    public AccountMoney(){}

    public AccountMoney(String accountNo, double balance){
        this.accountNo = accountNo;
        this.balance = balance;

    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance(){
        return this.balance;
    }

    public synchronized void draw(double drawAmount){
        try{
            if(!flag){
                wait();
            }
            else{
                System.out.println(Thread.currentThread().getName()+"取钱"+drawAmount);
                balance-=drawAmount;
                System.out.println("账户余额为"+balance);
                flag = false;
                notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public synchronized void deposit(double depositAmount){
        try{
            if(flag){
                wait();
            }
            else{
                System.out.println(Thread.currentThread().getName()+"存款"+depositAmount);
                balance+=depositAmount;
                System.out.println("账户余额为"+balance);
                flag = true;
                notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
