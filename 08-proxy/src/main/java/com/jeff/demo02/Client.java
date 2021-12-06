package com.jeff.demo02;

/**
 * @program: demo
 * @description:
 * @author: Jack Hu 2021/07/07 17:38
 */
public class Client {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        UserServiceProxy userServiceProxy = new UserServiceProxy(userService);
        userServiceProxy.add();
    }
}
