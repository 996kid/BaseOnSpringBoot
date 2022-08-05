package com.l3vi;

import com.l3vi.aop.EnhanceService;
import com.l3vi.aop.EnhanceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 996kid
 * @desription <p>测试spring boot 相关的内容诶</p>
 * @date 2019/10/30
 */
@SpringBootApplication
@EnableAsync
@RestController
public class Application {

    @Autowired
    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Configuration
    public class AsyncEventConfig {

        @Bean(name = "applicationEventMulticaster")
        public ApplicationEventMulticaster simpleApplicationEventMulticaster() {
            SimpleApplicationEventMulticaster eventMulticaster
                    = new SimpleApplicationEventMulticaster();

            eventMulticaster.setTaskExecutor(new SimpleAsyncTaskExecutor());
            return eventMulticaster;
        }

    }

    @Autowired
    private EnhanceService enhanceService;

    @GetMapping("/test")
    public String test() {
        EnhanceServiceImpl enhanceService = (EnhanceServiceImpl) applicationContext
                .getBean("enhanceServiceImpl");
        enhanceService.gretting("levi");
        return "success";
    }
}
