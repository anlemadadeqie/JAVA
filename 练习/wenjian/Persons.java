package wenjian;

import java.io.ObjectStreamException;
import java.util.ArrayList;

/**
 * Created by hjh on 16-7-25.
 */
public class Persons implements java.io.Serializable{
    private String name;
    private int age;
    public Persons(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private Object writeReplace() throws ObjectStreamException{
        ArrayList<Object> list = new ArrayList<>();
        list.add(name);
        list.add(age);
        return list;
    }
}
