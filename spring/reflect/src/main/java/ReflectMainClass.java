import entity.TestEntity;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 反射
 * 通过反射，我们可以在运行时获得程序或程序集中每一个类型的成员和成员的信息；
 * 根据需要动态加载需要的对象(是运行时而不是编译时)
 *
 * @author linhb
 * @create 2019-09-10
 */
public class ReflectMainClass {

    public static void main(String[] args) {
        try {
            /**反射实现的几个基本运用**/

            //1.获得 Class 对象
            Class a = getReflectClass();

            //2.判断是否为某个类的实例(class对象对比实例，区别instanceof)
            System.out.println("判断1：class isInstance TestEntity : "+a.isInstance(new TestEntity()));

            //3.创建实例
            Object instance = getInstance(a);

            //4.获取方法
            List<Method> methods = getObjectMethod(a);

            //5.获取构造器信息
            Object defaultContructObj = a.newInstance();
            Constructor[] constructors = a.getConstructors();

            //6.获取类的成员变量（字段）信息
            List<Field> fields = getObjField(a);

            //7.调用方法
            Method method = a.getMethod("publicMethod");
            Object invokeResult = method.invoke(instance);
            System.out.println("方法执行结果：invokeResult:"+invokeResult);

            //8.用反射创建数组
            getArray(a);

            System.out.println("*************END***************");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 三种获取Class对象的方式
     *
     * @return
     */
    public static Class<?> getReflectClass() throws Exception {
        //1.Class类静态方法
        Class a = Class.forName("entity.TestEntity");
        //2.直接获取
        Class b = int.class;
        //3.对象的getClass()方法
        Class c = new TestEntity().getClass();
        return a;
    }

    /**
     * 创建实例的两种方式
     *
     * @return
     */
    public static Object getInstance(Class a) throws Exception {
        //1.通过Class对象newInstance()创建实例
        Object testEntity = a.newInstance();
        //2.通过构造器：先通过Class对象获取指定的Constructor对象，再调用Constructor对象的newInstance()方法来创建实例
        Constructor[] constructors = a.getConstructors();
        Constructor constructor = a.getConstructor(a.getClasses());
        Object objC = constructor.newInstance();
        return testEntity;
    }

    /**
     * 获取对象方法
     * 有以下几种方式获取对象方法：
     * * getDeclaredMethods 方法返回类或接口声明的所有方法，包括公共、保护、默认（包）访问和私有方法，但不包括继承的方法。
     * * getMethods 方法返回某个类的所有公用（public）方法，包括其继承类的公用方法。
     *
     * @param c
     */
    public static List<Method> getObjectMethod(Class c) {
        //所有公共方法（包含父类公共方法）
        Method[] methods = c.getMethods();
        System.out.println("######getMethods#######");
        for (Method method : methods) {
            System.out.println(method+",");
        }
        System.out.println("#############");
        //所有方法(不包含父类)
        Method[] declaredMethods = c.getDeclaredMethods();
        System.out.println("######getDeclaredMethods#######");
        for (Method method : declaredMethods) {
            System.out.println(method+",");
        }
        System.out.println("#############");
        List<Method> arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(methods));
        arrayList.addAll(Arrays.asList(declaredMethods));
        return arrayList;
    }

    /**
     * 获取对象属性
     * 两种获取属性方法
     * * getFiled：访问公有的成员变量
     * * getDeclaredField：所有已声明的成员变量，但不能得到其父类的成员变量
     * @param c
     */
    public static List<Field> getObjField(Class c){
        System.out.println("@@@@@@@@@@");
        Field[] fields = c.getFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
        System.out.println("@@@@@@@@@@");
        Field[] declaredFields = c.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field.getName());
        }
        List<Field> list = new ArrayList<Field>();
        list.addAll(Arrays.asList(fields));
        list.addAll(Arrays.asList(declaredFields));
        return list;
    }

    /**
     * 反射创建数组
     * @param c
     * @return
     */
    public static List getArray(Class c)throws Exception{
        Class<?> cls = Class.forName("java.lang.String");
        Object array = Array.newInstance(cls,25);
        //往数组里添加内容
        Array.set(array,0,"hello");
        Array.set(array,1,"Java");
        Array.set(array,2,"fuck");
        Array.set(array,3,"Scala");
        Array.set(array,4,"Clojure");
        //获取某一项的内容
        System.out.println(Array.get(array,3));
        return null;
    }


}
