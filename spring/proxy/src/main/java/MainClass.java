package service;

import org.springframework.cglib.proxy.Enhancer;
import proxy.CglibProxy;
import proxy.JdkProxy;
import proxy.StaticProxy;
import service.impl.LoginImpl;
import service.impl.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author linhb
 * @create 2019-09-09
 */
public class MainClass {

    public static void main(String[] args) {
        System.out.println("******************************");
//        staticProxy();
//        jdkProxy(new UserServiceImpl());
//        jdkProxy(new LoginImpl());
        cgligProxyInvoke(new UserServiceImpl());
    }

    /**
     * 静态代理
     */
    public static void staticProxy(){
        //静态代理
        StaticProxy staticProxy = new StaticProxy();
        staticProxy.add();
    }

    /**
     * JDK动态代理
     * jdk的Proxy类，根据被代理对象，获取代理类实例，去执行接口方法，实现多态
     * @param serviceImpl 被代理的对象
     */
    public static void jdkProxy(UserService serviceImpl) {
        //注入被代理对象的实例
        InvocationHandler handler = new JdkProxy(serviceImpl);
        //通过反射方式，Proxy类获取代理对象实例(可以动态选择接口的实现类，执行add)
        UserService userService  = (UserService) Proxy.newProxyInstance(handler.getClass().getClassLoader(),serviceImpl.getClass().getInterfaces(),handler);
        userService.add();
    }

    /**
     * cglib 动态代理
     * 根据ASM框架通过字节码编织入代码
     * @param service
     */
    public static void cgligProxyInvoke(UserService service) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(service.getClass());
        enhancer.setCallback(new CglibProxy());
        UserService userService = (UserService) enhancer.create();
        userService.add();
        System.out.println("proxy class name:" + userService.getClass().getName());
    }
}
