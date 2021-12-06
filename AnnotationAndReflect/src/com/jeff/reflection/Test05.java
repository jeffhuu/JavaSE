package com.jeff.reflection;

/**
 * @program: demo
 * @description:
 * @author: Jack Hu 2021/08/27 15:48
 */
public class Test05 {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.m);
    }
}

class A {
    static {
        System.out.println("A类静态代码块初始化");
        m = 300;
    }

    static int m = 100;

    public A() {
        System.out.println("A类的无参构造初始化");
    }
}
