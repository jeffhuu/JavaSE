package flow;

import java.util.Scanner;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

/**
 * @author jeff
 * @date 2022/6/30 22:43
 **/
public class FlowTest {

    public static void main(String[] args) throws InterruptedException {
        // 首先创建一个 SubmissionPublisher 对象作为消息发布者。
        SubmissionPublisher<Integer> publisher = new SubmissionPublisher<>();

        Flow.Subscriber<Integer> subscriber = new Flow.Subscriber<Integer>() {

            private Flow.Subscription subscription;

            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                this.subscription = subscription;
                this.subscription.request(1);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("error!");
            }

            @Override
            public void onNext(Integer item) {
                // 订阅者能起到一个对发布者发布消息调速的作用
                System.out.println("接收到数据：" + item);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.subscription.request(1);
            }

            @Override
            public void onComplete() {
                System.out.println("completed!");
            }
        };


        publisher.subscribe(subscriber);
        for (int i = 0; i < 1000; i++) {
            // submit() 方法是一个同步阻塞方法，当subscription里的array缓冲池里的元素达到256后，就被阻塞里
            // 停下来等待订阅者消费完一条数据再继续产生数据
            System.out.println("生成数据：" + i);
            publisher.submit(i);
        }
        publisher.close();

        //主线程延迟停止，否则数据没有消费就退出
        Thread.currentThread().join(1000);
    }

}
