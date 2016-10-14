package reflex;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by hjh on 16-8-12.
 */
/*使用Proxy和InvocationHandler来生成动态代理对象*/
    interface  Person{
        void walk();
        void sayHello(String name);
}

class MyInvokationHandler implements InvocationHandler{

    /*执行动态代理对象的所有方法时，都会被替换成执行如下的invoke方法，
    proxy: 代表动态代理对象
    method : 代表需要执行的方法
    args : 代表调用目标方法时传入的实参 */

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("---正在执行的方法"+method);
        if(args != null){
            System.out.println("下面是执行该方法时传入的实参为：");
            for(Object val : args){
                System.out.println(val);
            }
        }
        else{
            System.out.println("调用该方法没有实参");
        }
        return null;
    }

}

public class ProxyTest {
    public static void main(String[] args){
        //创建一个InvocationHandler对象
        InvocationHandler handler = new MyInvokationHandler();

        //使用指定的InvocationHandler来生成一个动态代理对象
        Person p = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[]{Person.class}, handler);

        //调用动态代理对象的walk()和sayhello()方法
        p.walk();
        p.sayHello("胡嘉辉");

    }
}
