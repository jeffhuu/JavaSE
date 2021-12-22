package com.jeff.reflection;

/**
 * @program: demo
 * @description: 测试类什么时候会初始化
 * @author: Jack Hu 2021/12/07 11:25
 */
public class Test06 {
    static {
        System.out.println("Main类被加载");
    }

    public static void main(String[] args) {
        //1、主动引用
        Son son = new Son();
    }
}

class Father {

    static int b = 2;

    static {
        System.out.println("父类被加载");
    }
}

class Son extends Father {

    static {
        System.out.println("子类被加载");
        m = 300;
    }

    static int m = 100;
    static final int M = 1;
}
