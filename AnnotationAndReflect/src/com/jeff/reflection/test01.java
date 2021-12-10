package com.jeff.reflection;

/**
 * @program: demo
 * @description:
 * @author: Jack Hu 2021/07/19 17:36
 */
public class test01 {
    public static void main(String[] args) throws ClassNotFoundException {
//        Class<?> c1 = Class.forName("com.jeff.reflection.User");
//        System.out.println(c1);
//        Class c2 = new User().getClass();
//        System.out.println(c2);
//        System.out.println(c1.hashCode());
//        System.out.println(c2.hashCode());

    }
}

class User {
    private String name;

    private int id;

    private int age;

    public User() {

    }

    public User(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }
}