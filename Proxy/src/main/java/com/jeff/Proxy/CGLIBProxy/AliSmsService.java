package com.jeff.Proxy.CGLIBProxy;

/**
 * @program: JavaSE
 * @description:
 * @author: Jack Hu 2021/12/29 17:11
 */
public class AliSmsService {
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}
