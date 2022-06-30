package stream;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @program: JavaSE
 * @author: Jeff Hu 2022/06/28 18:03
 *
 * flatMap 可以把 Stream 中的每个元素都映射为一个 Stream，然后再把这多个 Stream 合并为一个 Stream。
 */
public class StreamDemo3 {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Optional<Integer> first = Stream.of(1, 2, 3, 4).parallel().findFirst();
            System.out.println("first.get() = " + first.get());
        }
        System.out.println("=============");
        for (int i = 0; i < 10; i++) {
            Optional<Integer> first = Stream.of(1, 2, 3, 4).parallel().findAny();
            System.out.println("first.get() = " + first.get());
        }
    }
}
