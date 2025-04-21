package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Before("execution(* com.example.demo.services.*.*(..))")
    public void logBefore() {
        System.out.println("Before method execution");
    }

    @After("execution(* com.example.demo.services.*.*(..))")
    public void logAfter() {
        System.out.println("After method execution");
    }

    @Around("execution(* com.example.demo.services.*.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Before Around: " + joinPoint.getSignature().getName());
        Object result = joinPoint.proceed(); // proceed with the method
        System.out.println("After Around: " + joinPoint.getSignature().getName());
        return result;
    }
}
