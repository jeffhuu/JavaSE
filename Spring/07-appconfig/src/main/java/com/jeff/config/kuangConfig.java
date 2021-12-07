package com.jeff.config;

import com.jeff.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
*@program: demo
*@description:
*@author: Jack Hu 2021/07/07 14:30
*/

@Configuration
public class kuangConfig {

    @Bean
    public User getUser() {
        return new User();
    }
}
