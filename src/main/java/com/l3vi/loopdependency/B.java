package com.l3vi.loopdependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 996kid@gmail.com
 * @Description B
 * @Date 2022/6/13 14:19
 */
@Component
public class B {

    @Autowired
    private A a;
}
