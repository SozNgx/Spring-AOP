package com.example.demo.Aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
@SuppressWarnings("all")
public class TestAspect {
    private static Logger logger = LoggerFactory.getLogger(TestAspect.class);

    @Pointcut("@annotation(com.example.demo.Annotation.SystemControllerLog)")
    public void controllerAspect(){}

    @Pointcut("@annotation(com.example.demo.Annotation.SystemServiceLog)")
    public void serviceAspect(){}

    @Before("controllerAspect()")
    public void doBefore(){
        logger.info("B c");
    }

    @AfterThrowing(pointcut = "serviceAspect()", throwing = "e")
    public void doAfterThrowing(){
        logger.info("s t e");
    }

}
