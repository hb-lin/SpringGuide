package entity;

/**
 * @author linhb
 * @create 2019-09-12
 */
public class TestThreadClass {

    public static void main(String[] args) throws InterruptedException {

        ThreadTest a = new ThreadTest("aa!!!!!");
        ThreadTest b = new ThreadTest("bb#####");
        ThreadTest c = new ThreadTest("cc@@@@@");
        a.start();
        a.join();
        b.start();
        b.join();
        c.start();
    }
}
class ThreadTest extends Thread{
    public ThreadTest(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0;i++<999999;){
            System.out.println(super.getName()+i);
        }
    }
}
class Foo {

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}