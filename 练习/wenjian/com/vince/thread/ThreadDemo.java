package wenjian.com.vince.thread;

/**
 * Created by hjh on 16-8-2.
 */
/*生产者与消费者的应用案例*/

/*生产者*/
class producter implements Runnable{
    private Food food;
    public producter(Food food){
        this.food = food;
    }


    @Override
    public void run() {
        for(int i = 0; i < 50; i++){
            if(i % 2 == 0) {
                   food.set("a","ccccccccc");
            }
            else{
                food.set("b","dddddddd");
            }
        }

    }
}

/*消费者*/
class consumer implements Runnable{

    private Food food;
    public consumer(Food food){
        this.food = food;
    }

    @Override
    public void run() {
        for(int i=0; i< 50; i++){
         food.get();
        }

    }
}

/*产品*/
class Food{
    private String name;
    private String content;

    public synchronized  void set(String name, String content){
        this.setName(name);
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.setContent(content);

    }

    public synchronized  void get(){
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getName()+":"+this.getContent());

    }
    public Food(){
    }

    public Food(String name, String content){
        this.name = name;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}

public class ThreadDemo {
    public static void main(String[] args){
        Food f = new Food();
        producter p = new producter(f);
        consumer c = new consumer(f);
        new Thread(p).start();
        new Thread(c).start();
    }
}
