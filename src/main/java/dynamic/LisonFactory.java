package dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/11 21:55
 * @description：
 * @modified By：
 * @version: 1.1
 */
public class LisonFactory implements InvocationHandler {
    private Object factory;

    public Object getFactory() {
        return factory;
    }

    public void setFactory(Object factory) {
        this.factory = factory;
    }

    public Object getInstance(){
        return Proxy.newProxyInstance(factory.getClass().getClassLoader()
                ,factory.getClass().getInterfaces(), this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doSomethingBefore();
        Object ret = method.invoke(factory, args);
        doSomethingAfter();
        return ret;
    }

    public void doSomethingBefore(){
        System.out.println("before");
    }

    public void doSomethingAfter(){
        System.out.println("after");
    }
}
