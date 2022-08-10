package vn.codegym.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class LogAspect {


    @Pointcut("execution(* vn.codegym.controller.BookController.borrow*(..))")
    public void borrowPointCut() {
    }

    @Before("borrowPointCut()")
    public void beforeCallBorrowBook(JoinPoint joinPoint) {
        System.out.println(">>>>>>>>> Start method name: " + joinPoint.getSignature().getName() + " - Time: " + LocalDateTime.now());
    }

    @AfterReturning("borrowPointCut()")
    public void afterCallBorrowBook(JoinPoint joinPoint) {
        System.out.println(">>>>>>>>> End method name: " + joinPoint.getSignature().getName() + " - Time: " + LocalDateTime.now());
    }

    @Pointcut("execution(* vn.codegym.controller.BookController.pay*(..))")
    public void payPointCut() {
    }

    @Before("payPointCut()")
    public void beforeCallPayBook(JoinPoint joinPoint) {
        System.out.println(">>>>>>>>> Start method name: " + joinPoint.getSignature().getName() + " - Time: " + LocalDateTime.now());
    }

    @AfterReturning("payPointCut()")
    public void afterCallPayBook(JoinPoint joinPoint) {
        System.out.println(">>>>>>>>> End method name: " + joinPoint.getSignature().getName() + " - Time: " + LocalDateTime.now());
    }

}
