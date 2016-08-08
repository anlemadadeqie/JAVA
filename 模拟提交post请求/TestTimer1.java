import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by hjh on 16-8-8.
 */
public class TestTimer1 {
    public static void showTimer1(){
        TimerTask task = new TimerTask(){

            @Override
            public void run() {

                Thread t1 =  new HttpClientTest3("线程1");
                t1.start();
                Thread t2 = new HttpClientTest3("线程2");
                t2.start();


            }
        };


        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        calendar.set(year,month,day,8,0,0);
        Date date = calendar.getTime();
        Timer timer = new Timer();
        timer.schedule(task,date);

    }

    public static void main(String[] args){
        showTimer1();
    }
}
