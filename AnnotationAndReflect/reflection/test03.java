package com.jeff.reflection;

/**
 * @program: demo
 * @description:
 * @author: Jack Hu 2021/07/23 17:37
 */
public class test03 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> c1 = Class.forName("com.jeff.reflection.Student");
        System.out.println(c1.hashCode());

        Class<Student> c2 = Student.class;
        System.out.println(c2.hashCode());

        Person person = new Student("1");
        Class<? extends Person> c3 = person.getClass();
        System.out.println(c3.hashCode());

        Class c4 = c1.getSuperclass();
        System.out.println(c4.hashCode());

        Class<Person> c5 = Person.class;
        System.out.println(c5.hashCode());
    }
}

class Person {
    public String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Student extends Person{

    public Student(String name) {
        this.name = "学生";
    }
}

class Teacher extends Person{

    public Teacher(String name) {
        this.name = "老师";
    }
}