package com.jeff.demo01;

/**
 * @program: demo
 * @description:
 * @author: Jack Hu 2021/07/07 16:22
 */
public class Proxy implements Rent{

    private Host host;

    public Proxy() {};

    public Proxy(Host host) {
        this.host = host;
    }

    @Override
    public void rent() {
        t1();
        host.rent();
        t2();
        t3();
    }

    public void t1() {
        System.out.println("do t1");
    }

    public void t2() {
        System.out.println("do t2");
    }

    public void t3() {
        System.out.println("do t3");
    }
}
