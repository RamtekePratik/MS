package com.mastercard.demo.demo.aspects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class ControllerAspects {


    private static final Logger LOGGER = LogManager.getLogger(ControllerAspects.class);
    //for all
    // @Around("execution(* MyClass.*(..))")
    @Around("execution(* com.mastercard.demo.demo.controllers.implementations.EmployeeController.createUser(Employee))")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        LOGGER.debug("Employee Controller Hit");
        joinPoint.proceed();
    }
}
