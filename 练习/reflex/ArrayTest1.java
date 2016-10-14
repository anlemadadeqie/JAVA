package reflex;

import java.lang.reflect.Array;

/**
 * Created by hjh on 16-8-12.
 */
public class ArrayTest1 {
    public static void main(String[] args){
        try{
            //创建一个元素类型为String,长度为10的数组
            Object arr = Array.newInstance(String.class,10);

            //依次为arr数组中index为5,6的元素赋值
            Array.set(arr, 5, "啊啊啊啊");
            Array.set(arr, 6,"啦啦啦");

            //取出元素
            Object book1 = Array.get(arr, 5);
            Object book2 = Array.get(arr, 6);

            //输出元素
            System.out.println(book1);
            System.out.println(book2);



        }catch (Throwable e){
            System.out.println(e);
        }
    }
}
