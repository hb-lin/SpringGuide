package com.linhb;

/**
 * @Author linhb
 * @Date 2020/6/18
 **/
public class TestClass {
    public int pubNum;
    private int privNum;
    public static int staNum;

    public void test(){
        //匿名内部类，一次性使用
        new Runnable(){
            @Override
            public void run() {

            }
        };
    }

    /**
     * 内部类
     */
    class innerClass{
        public int innerPubNum;

    }

    /**
     * 静态内部类
     */
    static class innerStaticClass{

    }


}
