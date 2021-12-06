package com.jeff.demo01;

/**
 * @program: demo
 * @description:
 * @author: Jack Hu 2021/07/07 15:55
 */
public class Client {
    public static void main(String[] args) {
        Host host = new Host();
        Proxy proxy = new Proxy(host);
        proxy.rent();
    }
}
