package wenjian;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by hjh on 16-7-25.
 */
public class ReplaceTest {
    public static void main(String[] args) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("replace.txt"));
             ObjectInputStream ooa = new ObjectInputStream(new FileInputStream("replace.txt"))) {

            Person pr = new Person("孙悟空", 500);
            oos.writeObject(pr);
            ArrayList list = (ArrayList) ooa.readObject();
            System.out.println(list);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
