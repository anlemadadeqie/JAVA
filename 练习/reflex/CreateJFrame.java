package reflex;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by hjh on 16-8-12.
 */
/*利用反射来创建一个jframe对象，而且使用指定构造器*/
public class CreateJFrame {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        //获取jframe对应的class对象
        Class<?> jframeClazz = Class.forName("javax.swing.JFrame");

        //获取jframe中带一个字符串参数的构造器
        Constructor ctor = jframeClazz.getConstructor(String.class);
        //调用constructor的newinstance方法创建对象
        Object obj = ctor.newInstance("测试窗口");
        System.out.println(obj);


    }
}