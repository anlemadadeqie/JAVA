package reflex;

/**
 * Created by hjh on 16-8-12.
 */

public class GunDog implements Dog{


    @Override
    public void info() {
        System.out.println("我是史努比");
    }

    @Override
    public void run() {
        System.out.println("我奔跑迅速");
    }
}
