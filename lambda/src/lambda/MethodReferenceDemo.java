package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author jeff
 * @date 2022/6/25 16:20
 **/

class Dog {

    private int food = 10;

    private String name = "啸天犬";

    public static void bark(Dog dog) {
        System.out.println(dog + " 叫了");
    }

    public int getFood() {
        return food;
    }

    public Dog() {
    }

    public Dog(int food, String name) {
        this.food = food;
        this.name = name;
    }

    /**
     * 吃狗粮
     * @param num
     * @return 还剩多少斤
     */
    public int eat(int num) {
        System.out.println(name + " 吃了" + num + "斤狗粮");
        food -= num;
        return food;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

public class MethodReferenceDemo {

    public static void main(String[] args) {
        // 方法引用
        Consumer<String> consumer = System.out::println;
        consumer.accept("打印一个值");

        // 静态方法的方法引用
        Consumer<Dog> consumer2 = Dog::bark;
        Dog dog = new Dog();
        consumer2.accept(dog);

        // 实例方法，使用对象实例的方法引用
        Function<Integer, Integer> function = dog::eat;
        // 这里将 dog 置空，下面的打印也不会报空指针，因为 Java 的变量都是值传递而不是引用传递，前面 function 已经被 dog 实例赋值了，
        // 就算 dog 变量引用指向了空，function 里仍然是一个有值的实例
        dog = null;
        System.out.println("还剩" + function.apply(2) + "斤");

        // 实例方法，使用类名的方法引用，因为 JDK 会将当前对象的 this 传入到每一个非静态方法中，且它是方法的第一个参数
        // 类名::方法名也能将实例方法作为方法引用，至于对应的函数式接口是哪个，就看方法的返回值或者方法的参数个数了。
        Dog dog2 = new Dog();
        BiFunction<Dog, Integer, Integer> function2 = Dog::eat;
        System.out.println("还剩" + function2.apply(dog2, 2) + "斤");

        Function<Dog, Integer> getFoodFunction = Dog::getFood;
        System.out.println("Dog::getFood 获取还剩 " + getFoodFunction.apply(dog2) + " 斤狗粮");

        // 构造方法的引用
        Supplier<Dog> supplier = Dog::new;
        System.out.println("无参构造方法的引用 " + supplier.get());

        BiFunction<Integer, String, Dog> dogBiFunction = Dog::new;
        System.out.println("有参构造方法的引用 " + dogBiFunction.apply(100, "富二代🐶"));

        // Java 值传递测试
        List<String> list = new ArrayList<>();
        test(list);

        System.out.println("Java 值传递测试: list 有变 null 吗？ " + list);
    }

    /**
     * Java 值传递测试
     * @param list
     */
    public static void test(List<String> list) {
        list = null;
    }
}
