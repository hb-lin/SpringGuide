package proxy;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Cglib代理,也叫作子类代理,它是在内存中构建一个子类对象从而实现对目标对象功能的扩展.
 * 1.Cglib是一个强大的高性能的代码生成包,它可以在运行期扩展java类与实现java接口.
 * 它广泛的被许多AOP的框架使用,例如Spring AOP和synaop,为他们提供方法的interception(拦截)
 * 2.Cglib包的底层是通过使用一个小而块的字节码处理框架ASM来转换字节码并生成新的类
 *
 * @author linhb
 * @create 2019-09-20
 */
public class CglibProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object obj, Method method, Object[] params, MethodProxy proxy) throws Throwable {
        System.err.println("=======before======");
        Object res = proxy.invokeSuper(obj, params);
        System.err.println("=======and======");
        return res;
    }

}
