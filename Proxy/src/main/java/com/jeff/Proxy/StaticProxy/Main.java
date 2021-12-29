package com.jeff.Proxy.StaticProxy;

/**
 * @program: JavaSE
 * @description:
 * @author: Jack Hu 2021/12/29 14:38
 */
public class Main {
    public static void main(String[] args) {
        SmsService smsService = new SmsServiceImpl();
        SmsProxy smsProxy = new SmsProxy(smsService);
        smsProxy.send("微信通知");
    }
}
