package com.example.actor_management.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.site.actor_management.service.*.*(..))")
    public void beforeMethod(JoinPoint joinPoint) {
        System.out.println(
                "Before method: " +
                        joinPoint.getSignature().getName()
        );
    }

    @Around("execution(* com.site.actor_management.service.*.*(..))")
    public Object aroundMethod(ProceedingJoinPoint joinPoint)
            throws Throwable {

        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long end = System.currentTimeMillis();

        System.out.println(
                "Execution time: " +
                        (end - start) +
                        " ms"
        );

        return result;
    }

    @After("execution(* com.site.actor_management.service.*.*(..))")
    public void afterMethod(JoinPoint joinPoint) {
        System.out.println(
                "After method: " +
                        joinPoint.getSignature().getName()
        );
    }

    @AfterReturning(
            pointcut = "execution(* com.site.actor_management.service.*.*(..))",
            returning = "result"
    )
    public void afterReturning(JoinPoint joinPoint, Object result) {
        System.out.println(
                "Successfully returned from: " +
                        joinPoint.getSignature().getName()
        );
    }

    @AfterThrowing(
            pointcut = "execution(* com.site.actor_management.service.*.*(..))",
            throwing = "exception"
    )
    public void afterThrowing(
            JoinPoint joinPoint,
            Exception exception) {

        System.out.println(
                "Exception in: " +
                        joinPoint.getSignature().getName()
        );
    }
}