package thread;

/**
 * Created by hjh on 16-7-28.
 */
public class DrawTest {
    public static void main(String[] args){
        Account act = new Account("DFG",1000);
        new DrawThread("甲",act,800).start();
        new DrawThread("乙",act,800).start();

    }
}
