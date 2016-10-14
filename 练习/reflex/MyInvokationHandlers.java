package reflex;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by hjh on 16-8-12.
 */
public class MyInvokationHandlers  implements InvocationHandler{

    //需要被代理的对象
    private  Object target;

    public void setTarget(Object target){
        this.target = target;
    }



    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        DogUtil du = new DogUtil();
        du.method1();
        Object result = method.invoke(target, args);
        du.method2();
        return  result;
    }
}
