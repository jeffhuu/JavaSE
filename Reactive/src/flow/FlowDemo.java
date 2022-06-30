package flow;

import java.util.Scanner;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

/**
 * @program: JavaSE
 * @author: Jeff Hu 2022/06/29 14:14
 *
 * 首先创建一个 SubmissionPublisher 对象作为消息发布者。
 * 接下来创建 Flow.Subscriber 对象作为消息订阅者，实现消息订阅者里边的四个方法，分别进行处理。
 * 为 publisher 配置上 subscriber。
 * 发送消息。
 * 消息发送完成后关闭 publisher。
 * 最后是让程序不要停止，观察消息订阅者打印情况。
 */
public class FlowDemo {

    public static void main(String[] args) {
        // 首先创建一个 SubmissionPublisher 对象作为消息发布者。
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();

        //接下来创建 Flow.Subscriber 对象作为消息订阅者，实现消息订阅者里边的四个方法，分别进行处理。
        Flow.Subscriber<String> subscriber = new Flow.Subscriber<String>() {
            private Flow.Subscription subscription;
            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                this.subscription = subscription;
                //向数据发布者请求一个数据
                this.subscription.request(1);
            }
            @Override
            public void onNext(String item) {
                System.out.println("接收到 publisher 发来的消息了：" + item);
                //接收完成后，可以继续接收或者不接收
                //this.subscription.cancel();
                this.subscription.request(1);
            }
            @Override
            public void onError(Throwable throwable) {
                //出现异常，就会来到这个方法，此时直接取消订阅即可
                this.subscription.cancel();
            }
            @Override
            public void onComplete() {
                //发布者的所有数据都被接收，并且发布者已经关闭
                System.out.println("数据接收完毕");
            }
        };
        //配置发布者和订阅者
        publisher.subscribe(subscriber);
        for (int i = 0; i < 5; i++) {
            //发送数据
            publisher.submit("hello:" + i);
        }
        //关闭发布者
        publisher.close();
        new Scanner(System.in).next();
    }

}
