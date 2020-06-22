package com.linhb.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author linhb
 * @Date 2020/5/27
 **/
public class TestArrayList {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.addAll(Arrays.asList("a","b","c","d","e","f"));
        //三种迭代方式
        for (Object obj : list) {
            if (obj.toString().equalsIgnoreCase("b")) {
                list.remove(obj);
            }
        }

        list.stream().forEach(ele-> System.out.println(ele.toString()));
        "ea".equalsIgnoreCase("");

        //线程安全问题
        //扩容和删除，引起线程安全问题

        Collections.synchronizedList(new ArrayList<>());
    }
}
