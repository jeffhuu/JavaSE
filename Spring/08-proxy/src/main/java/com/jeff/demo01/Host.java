package com.jeff.demo01;

/**
 * @program: demo
 * @description:
 * @author: Jack Hu 2021/07/07 15:54
 */
public class Host implements Rent {
    @Override
    public void rent() {
        System.out.println("房东要租房子");
    }
}
