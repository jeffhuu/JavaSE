package com.jeff.annotation;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: demo
 * @description:
 * @author: Jack Hu 2021/07/09 15:46
 */
public class demo1 extends Object{
    @Override
    public String toString() {
        return super.toString();
    }

    @Deprecated
    public static void test() {
        System.out.println("Deprecated");
    }

    @SuppressWarnings("uncheck")
    public void test02() {
        List list = new ArrayList<>();

    }

    public static void main(String[] args) {
        Test2.t();
    }
}

class Test2{
    public static void t() {
        System.out.println("ttt");
    }
}
