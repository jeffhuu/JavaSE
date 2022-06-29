package stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @program: JavaSE
 * @author: Jeff Hu 2022/06/28 17:10
 */
public class StreamDemo1 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        //外部迭代
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        System.out.println("外部迭代-结果为：" + sum);

        // 使用 stream 的内部迭代
        // map 就是中间操作(返回 stream 的操作都属于中间操作)
        // sum 就是终止操作(产生结果 或副作用)
        int sum2 = IntStream.of(nums).map(StreamDemo1::doubleNum).sum();

        System.out.println("内部迭代-结果为：" + sum2);

        System.out.println("惰性求值就是终止操作没有调用的情况下，中间操作不会执行");
        IntStream.of(nums).map(StreamDemo1::doubleNum);
    }

    public static int doubleNum(int i) {
        System.out.println("执行了乘以 2");
        return i * 2;
    }
}
