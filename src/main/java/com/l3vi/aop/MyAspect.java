package com.l3vi.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author 996kid@gmail.com
 * @Description MyAspect
 * @Date 2022/6/14 17:27
 */
@Aspect
@Component
public class MyAspect {

    @Pointcut("execution(* gretting(..))")// the pointcut expression
    private void anyOldGretting() {}// the pointcut signature


    @Around("com.l3vi.aop.MyAspect.anyOldGretting()")
    public Object enhancer(ProceedingJoinPoint joinPoint) {
        try {
            System.out.println("before enhance...");
            joinPoint.proceed();
            System.out.println("after enhance...");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
}
