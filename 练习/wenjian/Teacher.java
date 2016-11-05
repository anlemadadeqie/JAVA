package wenjian;

/**
 * Created by hjh on 16-7-25.
 */
/*对象引用的序列化*/
public class Teacher implements java.io.Serializable {
    private String name;
    private Person student;
    public Teacher(String name, Person student){
        this.name = name;
        this.student = student;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getStudent() {
        return student;
    }

    public void setStudent(Person student) {
        this.student = student;
    }
}
