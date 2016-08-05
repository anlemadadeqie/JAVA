import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by hjh on 16-8-4.
 */
public class TestTimer {
    static int count = 0;

    public static void showTimer(){
        TimerTask task = new TimerTask(){

            @Override
            public void run() {
                try {
                    HttpClientTest.myPost();
                } catch (IOException e) {
                    e.printStackTrace();
                }

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
        showTimer();
    }

}
