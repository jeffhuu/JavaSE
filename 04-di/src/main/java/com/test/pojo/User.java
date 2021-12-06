package com.test.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @program: demo
 * @description:
 * @author: Jack Hu 2021/07/01 17:21
 */
@Component
public class User {

    @Value("root")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
