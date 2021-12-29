package StaticProxy;

/**
 * @program: JavaSE
 * @description:
 * @author: Jack Hu 2021/12/29 14:35
 */
public class SmsServiceImpl implements SmsService {
    @Override
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}
