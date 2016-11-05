package wenjian;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by hjh on 16-7-25.
 */
public class ReadTeacher {
    public static void main(String[] args){
        try(ObjectInputStream iny = new ObjectInputStream(new FileInputStream("teacher.txt")))
        {
            Teacher p1 = (Teacher)iny.readObject();
            Teacher p2 = (Teacher)iny.readObject();
            Person p = (Person)iny.readObject();
            Teacher p3 = (Teacher) iny.readObject();
            System.out.println(p2 == p3);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

