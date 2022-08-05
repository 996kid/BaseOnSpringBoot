package com.l3vi.loopdependency;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * the Spring IoC container lets a BeanFactoryPostProcessor
 * read the configuration metadata and potentially change it
 * before the container instantiates any beans other than BeanFactoryPostProcessor instances.
 *
 *
 * @author 996kid@gmail.com
 * @Description MyBeanFactoryPostProcessor
 * @Date 2022/6/11 14:23
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {


    /**
     * Modify the application context's internal bean factory after its standard
     * initialization.
     *
     * bean definitions 已加载到容器， 但在实例化之前，自定义bean definitions
     * All bean definitions will have been loaded, but no beans
     * will have been instantiated yet.
     *
     * This allows for overriding or adding
     * properties even to eager-initializing beans.
     * @param beanFactory the bean factory used by the application context
     * @throws org.springframework.beans.BeansException in case of errors
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("myBeanConfiguration");
        System.out.println(beanDefinition.getFactoryMethodName());
        System.out.println(beanDefinition.getPropertyValues());
    }
}
