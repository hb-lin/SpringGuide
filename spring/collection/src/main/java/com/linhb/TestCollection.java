package com.linhb;

import java.time.temporal.ValueRange;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

/**
 * @Author linhb
 * @Date 2020/5/27
 **/
public class TestCollection {
    public static void main(String[] args) {
        try {
            Set set = new HashSet();
            Set set2 = new Hashtable<>();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
