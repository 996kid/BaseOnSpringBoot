package com.l3vi.loopdependency;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 996kid@gmail.com
 * @Description GetBean
 * @Date 2022/6/11 13:18
 */
public class GetBean implements ApplicationContextAware {

    ApplicationContext applicationContext;

    public void getBean() {
        applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.getBean("");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
