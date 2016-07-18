/**
 * Created by xuemei on 16-1-26.
 */
public class Customer {
    String name;
    int age;
    int id;

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }
    public void setAge(int age)
    {
        this.age = age;
    }

    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }

    public String tostring()
    {
        return "customer name"+name+",age"+age+",id"+id;
    }
}
