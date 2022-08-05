package com.l3vi.loopdependency;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 996kid@gmail.com
 * @Description MyBean
 * @Date 2022/6/11 14:33
 */
@Configuration
public class MyBeanConfiguration {

    @Autowired
    private ApplicationContext applicationContext;


    @Bean(initMethod = "")
//    @Lazy
    public SimpleBean simpleBean() {
        return new SimpleBean();
    }

    @Data
    class SimpleBean {

    }

}
