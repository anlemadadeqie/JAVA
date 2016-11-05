package wenjian;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by hjh on 16-7-25.
 */
/*java引用的序列化和反序列化*/
public class WriteTeacher {
    public static void main(String[] args){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("teacher.txt")))
        {
            Person per = new Person("孙悟空",500);
            Teacher t1 = new Teacher("唐僧",per);
            Teacher t2 = new Teacher("菩萨",per);
            oos.writeObject(t1);
            oos.writeObject(t2);
            oos.writeObject(per);
            oos.writeObject(t2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

