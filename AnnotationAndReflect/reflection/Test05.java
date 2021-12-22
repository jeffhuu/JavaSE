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

    /*
    1、加载到内存，会产生一个类对应的 Class 对象
    2、链接 ，链接结束后 m = 0
    3、初始化

            <clinit>() {
                 System.out.println("A类静态代码块初始化,此时m已经被分配内存并设置类变量默认初始值");
                 m = 300;
                 m = 100;
            }
            类构造器 <clinit>()方法是由编译期自动收集类中所有类变量的赋值动作和静态
            代码块中的语句合并产生的。(类构造器 是构造类信息的，不是构造该类对象的构造器)。

     4、类的加载与ClassLoader的理解
     ➢加载:将class文件字节码内容加载到内存中，并将这些静态数据转换成方法区的运行时数据结构,
     然后生成一个代表这个类的java.lang.Class对象.
     ➢链接:将Java类的二进制代码合并到JVM的运行状态之中的过程。
     ➢验证:确保加载的类信息符合JVM规范，没有安全方面的问题
     ➢准备:正式为类变量(static) 分配内存并设置类变量默认初始值的阶段,这些内存都将在方法区中进行分配。
     ➢解析:虚拟机常量池内的符号引用(常量名)替换为直接引用(地址)的过程。
     ➢初始化:
     ➢执行类构造器< clinit> ()方法的过程。类构造器<clinit> ()方法是由编译期自动收集类中所有类变量的赋值动作和静态
     代码块中的语句合并产生的。(类构造器 是构造类信息的，不是构造该类对象的构造器)。
     ➢当初始化- 个类的时候，如果发现其父类还没有进行初始化，则需要先触发其父类的初始化。·
     ➢虚拟机会保证- 个类的< clinit> ()方法在多线程环境中被正确加锁和同步。

     */
}

class A {
    static {
        System.out.println("A类静态代码块初始化,此时m已经被分配内存并设置类变量默认初始值");
        m = 300;
    }

    static int m = 100;

    public A() {
        System.out.println("A类的无参构造初始化");
    }

}
