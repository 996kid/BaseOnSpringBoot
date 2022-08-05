package com.l3vi.aop;

import org.springframework.stereotype.Service;

/**
 * @author 996kid@gmail.com
 * @Description EnhanceServiceImpl
 * @Date 2022/6/14 17:26
 */
@Service
public class EnhanceServiceImpl implements EnhanceService {
    
    @Override
    public void gretting(String name) {
        System.out.println("Hello, " + name);
    }
}
