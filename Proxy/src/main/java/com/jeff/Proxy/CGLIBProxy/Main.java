package com.jeff.Proxy.CGLIBProxy;

/**
 * @program: JavaSE
 * @description:
 * @author: Jack Hu 2021/12/29 17:18
 */
public class Main {
    public static void main(String[] args) {
        AliSmsService aliSmsService = (AliSmsService) CglibProxyFactory.getProxy(new AliSmsService());
        aliSmsService.send("haha");
    }
}
