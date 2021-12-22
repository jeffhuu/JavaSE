package com.jeff.reflection;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * @program: demo
 * @description:
 * @author: Jack Hu 2021/12/14 15:30
 */
public class Test12 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class<?> c1 = Class.forName("com.jeff.reflection.Student2");

        //通过反射获得注解
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        //获得注解的 value 值
        TableLavan annotation = c1.getAnnotation(TableLavan.class);
        System.out.println(annotation.value());

        //通过反射获得属性的注解
        Field f = c1.getDeclaredField("id");
        FieldLavan annotationId = f.getAnnotation(FieldLavan.class);
        System.out.println(annotationId);
        System.out.println(annotationId.columnName());
        System.out.println(annotationId.type());
        System.out.println(annotationId.length());

    }
}

@TableLavan("db_student")
class Student2 {

    @FieldLavan(columnName = "id", type = "integer", length = 10)
    private int id;

    @FieldLavan(columnName = "age", type = "integer", length = 10)
    private int age;

    @FieldLavan(columnName = "name", type = "varchar", length = 10)
    private String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

//类名的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TableLavan {
    String value();
}

//属性的注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldLavan {
    String columnName();
    String type();
    int length();
}