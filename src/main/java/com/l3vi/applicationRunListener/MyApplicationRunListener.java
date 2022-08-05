package com.l3vi.applicationRunListener;

import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.time.Duration;

/**
 * @author 996kid@gmail.com
 * @Description MyApplicationRunListener
 * @Date 2022/6/12 13:32
 */
public class MyApplicationRunListener implements SpringApplicationRunListener {

    public MyApplicationRunListener(SpringApplication springApplication, String[] args) {
        super();
    }

    @Override
    public void starting(ConfigurableBootstrapContext bootstrapContext) {

    }

    @Override
    public void environmentPrepared(ConfigurableBootstrapContext bootstrapContext, ConfigurableEnvironment environment) {

    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {

    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {

    }

    @Override
    public void started(ConfigurableApplicationContext context, Duration timeTaken) {

    }

    @Override
    public void ready(ConfigurableApplicationContext context, Duration timeTaken) {

    }
}
