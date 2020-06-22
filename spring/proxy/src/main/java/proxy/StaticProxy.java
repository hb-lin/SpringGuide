package proxy;

import service.UserService;
import service.impl.UserServiceImpl;

/**
 * 静态代理类
 * 缺陷：每个接口都需要创建代理类，太过繁琐
 * @author linhb
 * @create 2019-09-09
 */
public class StaticProxy implements UserService {

    private UserService userService = new UserServiceImpl();

    @Override
    public void add() {
        System.out.println("静态代理类：before ADD");
        userService.add();
        System.out.println("静态代理类：after ADD");
    }
}
