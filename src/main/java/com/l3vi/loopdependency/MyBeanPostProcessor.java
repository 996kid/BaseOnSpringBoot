package com.l3vi.loopdependency;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * BeanPostProcessor 和 BeanFactoryPostProcessor
 * BeanPostProcessor
 * Factory hook that allows for custom modification of new bean instances &mdash;
 *  for example, checking for marker interfaces or wrapping beans with proxies.
 *
 *  BeanFactoryPostProcessor
 *  Factory hook that allows for custom modification of an application context's
 *  bean definitions, adapting the bean property values of the context's underlying
 *  bean factory.
 *
 *  Spring 容器会优先实例化 BeanFactoryPostProcessor，
 *  以便通过 BeanFactoryPostProcessor 来完成对其他 bean definition 修改
 *
 * @author 996kid@gmail.com
 * @Description BeanPostProcessor
 * @Date 2022/6/11 14:27
 */
//@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName);
        return bean;
    }
}
