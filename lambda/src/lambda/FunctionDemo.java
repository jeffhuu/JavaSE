package lambda;

import java.util.function.Consumer;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author jeff
 * @date 2022/6/25 16:10
 **/
public class FunctionDemo {

    public static void main(String[] args) {
        // 断言
        Predicate<Integer> predicate = i -> i > 0;
        System.out.println(predicate.test(-1));

        // 消费（下面是方法引用）
        Consumer<String> consumer1 = s -> System.out.println(s);
        Consumer<String> consumer2 = System.out::println;
        consumer1.accept("consumer1");
        consumer2.accept("consumer2");

        // 供应
        Supplier<String> supplier = () -> "supplier";
        System.out.println(supplier.get());
    }

}
