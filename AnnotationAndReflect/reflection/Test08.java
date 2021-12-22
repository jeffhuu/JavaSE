package com.jeff.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @program: demo
 * @description:
 * @author: Jack Hu 2021/12/10 15:56
 */
public class Test08 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class<?> c1 = Class.forName("com.jeff.reflection.User");

        //获得类的名字
        System.out.println(c1.getName()); //类名 + 包名
        System.out.println(c1.getSimpleName()); //类名

        System.out.println("================================");
        //获取类的属性(只能获取 public 属性)
        Field[] fields = c1.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        //获取类的属性(获取 所有 属性)
        Field[] fieldsDes = c1.getDeclaredFields();
        for (Field declaredField : fieldsDes) {
            System.out.println(declaredField);
        }
        //获取指定属性的值(获取 所有 属性)
        Field declaredField = c1.getDeclaredField("name");
        System.out.println(declaredField);
        //NoSuchFieldException ===> 获取指定属性的值(只能获取 public 属性)
//        Field field = c1.getField("name");
//        System.out.println(field);

        //获取类的方法
        System.out.println("================================");
        Method[] methods = c1.getMethods();   //获取本类及父类的所有 public 方法
        for (Method method : methods) {
            System.out.println("正常的：" + method);
        }

        Method[] declaredMethods = c1.getDeclaredMethods();//获取本类 所有 方法
        for (Method method : declaredMethods) {
            System.out.println("declaredFields：" + method);
        }

        //获取类的指定方法
        //为什么需要参数 parameterTypes？ 因为 Java 中的重载，需要根据参数类型、数量，来判断同名方法是否为同一个方法
        Method getName = c1.getMethod("getName", null);
        Method setName = c1.getMethod("setName", String.class);
        System.out.println(getName);
        System.out.println(setName);

        //获取指定的构造器
        System.out.println("================================");
        Constructor<?>[] constructors = c1.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
        Constructor<?>[] declaredConstructors = c1.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("#" + declaredConstructor);
        }

        Constructor<?> declaredConstructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        System.out.println(declaredConstructor);
    }
}
