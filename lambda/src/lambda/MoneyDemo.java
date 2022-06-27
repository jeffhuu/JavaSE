package lambda;

import java.text.DecimalFormat;
import java.util.function.Function;

/**
 * @author jeff
 * @date 2022/6/25 14:11
 *
 * 利用函数式接口灵活地格式化打印存款
 **/

class MyMoney {
    private final int money;

    public MyMoney(int money) {
        this.money = money;
    }

    void printFormatMoney(Function<Integer, String> iMoneyFormat) {
        System.out.println("我的存款：" + iMoneyFormat.apply(money));
    }
}

public class MoneyDemo {

    public static void main(String[] args) {
        MyMoney me = new MyMoney(999999999);
        Function<Integer, String> myMoneyFormat = i -> new DecimalFormat("#,###").format(i);

        // 函数接口链式操作
        me.printFormatMoney(myMoneyFormat.andThen(format -> "人民币 " + format));
    }

}
