package reflex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by hjh on 16-8-12.
 */

/*使用默认构造器实现一个简单的对象池*/
public class ObjectPoolFactory {
    //定义一个对象池，前面是对象名，后面是实际对象
    private Map<String, Object> objectPool = new HashMap<>();

    //定义一个创建对象的方法
    //该方法只要传入一个字符串类名,程序可以根据该类名生成java对象
    private Object createObject(String clazzName) throws InstantiationError, ClassNotFoundException, IllegalAccessException, InstantiationException {
        //根据字符串来获取对应的class对象
        Class<?>  clazz = Class.forName(clazzName);
        return clazz.newInstance();

    }

    //该方法会根据指定文件来初始化对象池
    //它会根据配置文件来创建对象
    public void initPool(String fileName) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        try(FileInputStream fis  = new FileInputStream(fileName) ){
            Properties props = new Properties();
            props.load(fis);
            for(String name : props.stringPropertyNames()){
                //每取出一对key-value对，就根据value创建一个对象
                //调用createObject()创建对象，并将对象添加到对象池中
                objectPool.put(name, createObject(props.getProperty(name)));

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("读取"+fileName+"异常");
        }
    }


    public Object getObject(String name){
        return objectPool.get(name);
    }

    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        ObjectPoolFactory pf = new ObjectPoolFactory();
        pf.initPool("obj.txt");
        System.out.println(pf.getObject("a"));
        System.out.println(pf.getObject("b"));

    }

}
