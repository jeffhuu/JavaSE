package com.jeff.demo02;

/**
 * @program: demo
 * @description:
 * @author: Jack Hu 2021/07/07 17:44
 */
public class UserServiceProxy implements UserService{

    private UserService userService;

    public UserServiceProxy(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void add() {
        log("增加");
        userService.add();
    }

    @Override
    public void delete() {
        log("删除");
        userService.delete();
    }

    @Override
    public void update() {
        log("更新");
        userService.update();
    }

    @Override
    public void query() {
        log("查询");
        userService.query();
    }

   public void log(String msg) {
        System.out.println("执行了 "+ msg + " 操作");
    }
}
