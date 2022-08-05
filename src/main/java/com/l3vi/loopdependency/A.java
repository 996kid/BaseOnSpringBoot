package com.l3vi.loopdependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 996kid@gmail.com
 * @Description A
 * @Date 2022/6/13 14:18
 */
@Component
public class A {

    @Autowired
    private B b;
}
