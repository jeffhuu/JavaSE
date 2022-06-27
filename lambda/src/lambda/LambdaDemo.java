package lambda;

/**
 * @author Jeff Hu
 * @ClassName: LambdaDemo
 * @Description: TODO
 * @date 2022/6/25 14:11
 **/
public class LambdaDemo {

    public static void main(String[] args) {
        Interface1 i1 = new Interface1() {
            @Override
            public int doubleNum(int i) {
                return i * 2;
            }
        };
        System.out.println(i1.doubleNum(10));

        Interface1 i2 = i -> i * 2;
        System.out.println(i2.doubleNum(30));

        Interface1 i3 = (int i) -> i * 2;
        System.out.println(i3.doubleNum(40));

        Interface1 i4 = i -> {
            System.out.println("i4");
            return i * 2;
        };
        System.out.println(i4.doubleNum(100));
    }

}

@FunctionalInterface
interface Interface1 {
    int doubleNum(int i);

    default int add(int x, int y) {
        return x + y;
    }
}

@FunctionalInterface
interface Interface2 {
    int doubleNum(int i);

    default int add(int x, int y) {
        return x + y;
    }
}

@FunctionalInterface
interface Interface3 extends Interface1, Interface2{

    @Override
    default int add(int x, int y) {
        return Interface1.super.add(x, y);
    }
}

