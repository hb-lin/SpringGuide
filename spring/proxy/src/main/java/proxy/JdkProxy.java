package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * JDK动态代理
 * @author linhb
 * 基于接口的动态代理
 *
 * Proxy.newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler handler)方法，该方法会根据指定的参数动态创建代理对象。
 * 三个参数的意义如下：
 * loader: 指定代理对象的类加载器；
 * interfaces: 代理对象需要实现的接口，可以同时指定多个接口；
 * handler: 方法调用的实际处理者，代理对象的方法调用都会转发到这里（*注意1）。
 * newProxyInstance()会返回一个实现了指定接口的代理对象，对该对象的所有方法调用都会转发给InvocationHandler.invoke()方法。
 * @create 2019-09-09
 */
public class JdkProxy implements InvocationHandler {

    private Object subject;
    /**
     * 注入实例
     * @param object
     */
    public JdkProxy(Object object){
        this.subject = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("使用jdk动态代理:before invoke:"+method.getName());
        Object object = method.invoke(subject,args);
        System.out.println("使用jdk动态代理:after invoke:"+method.getName());
        return object;
    }


}
