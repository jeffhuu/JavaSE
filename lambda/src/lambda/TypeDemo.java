package lambda;

@FunctionalInterface
interface IMath {
    int add(int x, int y);
}

@FunctionalInterface
interface IMath2 {
    int sum(int x, int y);
}

/**
 * @program: JavaSE
 * @author: Jeff Hu 2022/06/28 11:42
 *
 * JDK 8 类型推断
 */
public class TypeDemo {

    public static void main(String[] args) {

        // 变量类型推断
        IMath lambda = (x, y) -> x + y;

        // 数组里
        IMath[] lambdas = { (x, y) -> x + y };

        // 强转推断，不强转会报错，编译器不知道什么类型
        Object lambda2 = (IMath) (x, y) -> x + y;

        // 通过返回类型推断
        IMath createLambda = createLambda();

        TypeDemo typeDemo = new TypeDemo();
        // 当有二义性时,使用强转对应的接口解决
        typeDemo.test((IMath2) Integer::sum);

    }

    public static IMath createLambda() {
        return Integer::sum;
    }

    public void test(IMath iMath) {
        System.out.println(iMath.add(10, 2));
    }

    public void test(IMath2 iMath2) {
        System.out.println(iMath2.sum(1, 2));
    }
}
