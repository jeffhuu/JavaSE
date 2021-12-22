package com.jeff.reflection;

/**
 * @program: demo
 * @description:
 * @author: Jack Hu 2021/12/10 15:34
 */
public class Test07 {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

        Class<?> loader = Class.forName("com.jeff.reflection.Test07");
        System.out.println(loader.getClassLoader());

        loader = Class.forName("java.util.List");
        System.out.println(loader.getClassLoader());

        System.out.println(System.getProperty("java.class.path"));
    }
}
