package lambda;

import java.util.function.Function;

/**
 * @program: JavaSE
 * @author: Jeff Hu 2022/06/28 15:59
 *
 * 级联表达式和柯里化
 * 柯里化：把多个参数的函数转换为只有一个参数的函数
 * 柯里化的目的：函数标准化，所有函数都只有一个参数，调用起来比较灵活
 *
 */
public class CurryDemo {

    public static void main(String[] args) {

        // 只传递一个参数实现了 x + y 的效果
        Function<Integer, Function<Integer, Integer>> function = x -> y -> x + y;
        System.out.println(function.apply(1).apply(2));

        // 类似 js var a = add(2)(3)(4)
        // 解题关键：add()函数需要返回一个加法函数，而不是一个普通的值，即定义add()，并想办法让add()返回一个add()。js最显著的特征就是函数的返回值可以是一个函数。
        // Java 使用柯里化也能实现这个效果,本质也是函数的返回值是函数
        Function<Integer, Function<Integer, Function<Integer, Integer>>> function2 = x -> y -> z -> x + y + z;
        System.out.println(function2.apply(2).apply(3).apply(4));

        int[] nums = {2, 3, 4};
        Function f = function2;
        // 柯里化的好处，函数标准化了，所有函数都可以在循环里面批量统一处理
        for (int i = 0; i < nums.length; i++) {
            if (f instanceof Function) {
                Object obj = f.apply(nums[i]);
                if (obj instanceof Function) {
                    f = (Function) obj;
                } else {
                    System.out.println("调用结束，结果为：" + obj);
                }
            }
        }
    }
}
