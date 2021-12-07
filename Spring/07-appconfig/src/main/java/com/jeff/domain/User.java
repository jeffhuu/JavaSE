package com.jeff.domain;

import org.springframework.beans.factory.annotation.Value;

/**
 * @program: demo
 * @description:
 * @author: Jack Hu 2021/07/07 14:23
 */
public class User {
    private String name;

    public String getName() {
        return name;
    }

    @Value("test")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
