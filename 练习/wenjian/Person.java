package wenjian;

/**
 * Created by hjh on 16-7-25.
 */
public class Person implements java.io.Serializable {
    private String name;
    private int age;
    public Person(String name, int age){
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
}
