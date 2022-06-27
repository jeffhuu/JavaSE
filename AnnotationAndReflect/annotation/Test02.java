package annotation;

import java.lang.annotation.*;

/**
 * @program: demo
 * @description:
 * @author: Jack Hu 2021/07/09 15:50
 */
//测试元注解
public class Test02 {

    @MyAnnotation
    public void test() {

    }
}

//定义一个注解
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    String value() default "";
}