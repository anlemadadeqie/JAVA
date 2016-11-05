package wenjian;

import java.io.*;
/*对象流的序列化和反序列化*/

/**
 * Created by hjh on 16-7-25.
 */
public class WriteObject {
    public static void main(String[] args){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.txt")))
        {
            Person p = new Person("孙悟空",500);
            oos.writeObject(p);
        }
        catch(IOException e){
                                                                                                                     e.printStackTrace();
        }

        try(ObjectInputStream oot = new ObjectInputStream(new FileInputStream("object.txt")))
        {
            Person d = (Person)oot.readObject();
            System.out.println(d.getName()+d.getAge());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
