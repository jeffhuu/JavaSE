package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @program: JavaSE
 * @author: Jeff Hu 2022/06/28 15:24
 */
public class VarDemo {

    /**
     *
     * Java 中局部内部类和匿名内部类访问的局部变量必须由 final 修饰，以保证内部类和外部类的数据一致性。但从 Java 8 开始，我们可以不加 final 修饰符，由系统默认添加，当然这在 Java 8 以前的版本是不允许的。Java 将这个功能称为 Effectively final 功能。
     */
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        // 内部类引用外部类的变量，这个变量必须是 final
//        list = new ArrayList<>(); //编译器报错
        // Java 是值传递，上面的 list 和下面的 list 是两个局部变量，都指向 ArrayList 对象
        Consumer<String> consumer = s -> System.out.println(s + list);
        consumer.accept("123");
    }

}
