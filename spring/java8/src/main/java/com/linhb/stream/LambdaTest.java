package com.linhb.stream;

import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * java 8 Lambda表达式和函数式接口
 * @Author linhb
 * @Date 2020/5/25
 **/
public class LambdaTest {

    public void testLambda(){
        // 表达式：->
        Arrays.asList( "a", "b", "d" ).forEach(e -> System.out.println( e ) );
        //编译推断的参数类型也可自己指定
        Arrays.asList( "a", "b", "d" ).forEach((String e)-> System.out.println( e ) );

        //Lambda表达式可能会引用类的成员或者局部变量（会被隐式地转变成final类型），下面两种写法的效果是一样的：
        String separator = ",";
        // final String separator = ",";
        Arrays.asList( "a", "b", "d" ).forEach(e -> System.out.print( e + separator ) );

    }

    /**
     * 语言的设计者们思考了很多如何让现有的功能和lambda表达式友好兼容。于是就有了函数接口这个概念。
     * 函数接口是一种只有一个方法的接口，像这样地，函数接口可以隐式地转换成lambda表达式。
     * java.lang.Runnable 和java.util.concurrent.Callable是函数接口两个最好的例子。
     * 但是在实践中，函数接口是非常脆弱的，只要有人在接口里添加多一个方法，那么这个接口就不是函数接口了，就会导致编译失败。
     * Java 8提供了一个特殊的注解@FunctionalInterface来克服上面提到的脆弱性并且显示地表明函数接口的目的（java里所有现存的接口都已经加上了@FunctionalInterface）
     */
    @FunctionalInterface
    public interface Functional {
        void method();
    }

    /**
     * 默认和静态方法。
     */
    private interface Defaulable {
        /**
         * 默认方法：不会强迫实现接口的类实现默认方法
         * eg:对Collection增加stream()
         * @return
         */
        default String notRequired() {
            return "Default implementation";
        }
        /**
         *  接口内可以加静态方法
         * @param supplier
         * @return
         */
        static Defaulable create( Supplier< Defaulable > supplier ) {
            return supplier.get();
        }
    }

    /**
     * 方法引用
     */
    public static class Car {
        public static Car create( final Supplier< Car > supplier ) {
            return supplier.get();
        }
        public static void collide( final Car car ) {
            System.out.println( "Collided " + car.toString() );
        }
        public void repair() {
            System.out.println( "Repaired " + this.toString() );
        }
        public void follow( final Car another ) {
            System.out.println( "Following the " + another.toString() );
        }
        void test(){
            //1.构造方法引用，语法是：Class::new ，对于泛型来说语法是：Class<T >::new，请注意构造方法没有参数
            Car car = Car.create(Car::new);
            List<Car> cars = Arrays.asList(car);
            //2.静态方法引用，语法是：Class::static_method请注意这个静态方法只支持一个类型为Car的参数
            cars.forEach(Car::collide);
            //3.类实例的方法引用，语法是：Class::method请注意方法没有参数
            cars.forEach(Car::repair);
            //4.引用特殊类的方法，语法是：instance::method，请注意只接受Car类型的一个参数
            Car policeCar = Car.create(Car::new);
            cars.forEach(policeCar::follow);
        }
    }

    /**
     * 重复注释:
     * 重复注释本身需要被@Repeatable注释。
     * 实际上，他不是一个语言上的改变，只是编译器层面的改动，技术层面仍然是一样的。
     */
//    @ComponentScan.Filter(Filters.class)
//    @ComponentScan.Filter()
    private interface Filterable {

    }

    /**
     * 更好的类型推断
     */


}
