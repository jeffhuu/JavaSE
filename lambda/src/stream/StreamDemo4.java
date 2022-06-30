package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author jeff
 * @date 2022/6/28 22:59
 **/
public class StreamDemo4 {


    List<String[]> eggs = new ArrayList<>();

    public void init() {
        // 第一箱鸡蛋
        eggs.add(new String[]{"鸡蛋_1", "鸡蛋_1", "鸡蛋_1", "鸡蛋_1", "鸡蛋_1"});
        // 第二箱鸡蛋
        eggs.add(new String[]{"鸡蛋_2", "鸡蛋_2", "鸡蛋_2", "鸡蛋_2", "鸡蛋_2"});
    }

    // 自增生成组编号
    static int group = 1;
    // 自增生成学生编号
    static int student = 1;

    /**
     * 把二箱鸡蛋分别加工成煎蛋，还是放在原来的两箱，分给2组学生
     */
    public void map() {
        eggs.stream()
                .map(x -> Arrays.stream(x).map(y -> y.replace("鸡", "煎")))
                .forEach(x -> System.out.println("组" + group++ + ":" + Arrays.toString(x.toArray())));
    /*
    控制台打印：------------
    组1:[煎蛋_1, 煎蛋_1, 煎蛋_1, 煎蛋_1, 煎蛋_1]
    组2:[煎蛋_2, 煎蛋_2, 煎蛋_2, 煎蛋_2, 煎蛋_2]
     */
    }

    /**
     * 把二箱鸡蛋分别加工成煎蛋，然后放到一起【10个煎蛋】，分给10个学生
     */
    public void flatMap() {
        eggs.stream()
                .flatMap(x -> Arrays.stream(x).map(y -> y.replace("鸡", "煎")))
                .forEach(x -> System.out.println("学生" + student++ + ":" + x));
    /*
    控制台打印：------------
    学生1:煎蛋_1
    学生2:煎蛋_1
    学生3:煎蛋_1
    学生4:煎蛋_1
    学生5:煎蛋_1
    学生6:煎蛋_2
    学生7:煎蛋_2
    学生8:煎蛋_2
    学生9:煎蛋_2
    学生10:煎蛋_2
     */
    }

    public static void main(String[] args) {
        StreamDemo4 streamDemo4 = new StreamDemo4();
        streamDemo4.init();
//        streamDemo4.flatMap();


        /**
         * JAVA8 中 Map 与 flatMap 区别
         * map(func) 函数会对每一条输入进行指定的 func 操作，然后为每一条输入返回一个对象；
         * 而 flatMap(func) 也会对每一条输入进行执行的 func 操作，然后每一条输入返回一个对象，
         * 但是最后会将所有的对象再合成为一个对象；
         * 从返回的结果的数量上来讲，map 返回的数据对象的个数和原来的输入数据是相同的，而 flatMap返回的个数则是不同的。
         */
        String[] words = {"Hello", "World"};

        //{h,e,l,l,o},{W,o,r,l,d}
        Stream<String[]> stream = Arrays.stream(words).map(w -> w.split(""));//Stream<String[]>
//        stream.map(Arrays::asList).forEach(System.out::println);
        //H,e,l,l,o,W,o,r,l,d
        Stream<String> stringStream = stream.flatMap(Arrays::stream);

        stringStream.distinct().forEach(System.out::println);
    }

}
