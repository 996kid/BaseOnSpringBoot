package com.l3vi.basespringboottest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 996kid@gmail.com
 * @Description TestController
 * @Date 2022/6/27 11:29
 */
@RestController
public class TestController {

    private static final int _10M = 1024 * 1024 * 10;

    @GetMapping("/memoryLeakTest")
    public String memoryLeakTest() {
        ThreadLocal<Byte[]> threadLocal = new ThreadLocal<>();
        threadLocal.set(new Byte[_10M]);
        return "success";
    }
}
