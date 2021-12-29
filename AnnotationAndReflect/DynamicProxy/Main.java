package DynamicProxy;

/**
 * @program: JavaSE
 * @description:
 * @author: Jack Hu 2021/12/29 16:43
 */
public class Main {
    public static void main(String[] args) {
        SmsService smsService = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
        String s = smsService.send1("msg");
    }
}
