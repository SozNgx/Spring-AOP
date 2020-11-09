package com.example.demo.Aspect;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
@Slf4j
public class EmployeeAspect {
   private static final Logger logger = LoggerFactory.getLogger(EmployeeAspect.class);

   @Around("execution(* com.example.demo.Servive..*(..))")
    public Object ServiceAll(ProceedingJoinPoint joinPoint) throws Throwable {
       MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
       String className = methodSignature.getDeclaringType().getSimpleName();
       String methodName = methodSignature.getName();

       final StopWatch stopWatch = new StopWatch();
       stopWatch.start();
       Object result = joinPoint.proceed();
       stopWatch.stop();
       logger.info("Execution time of " + className + "." + methodName + " :: " + stopWatch.getTotalTimeMillis() + "ms");
       return result;
   }

   @Before("execution(* com.example.demo.Controller..*(..))")
   public void ControllerStart(JoinPoint joinPoint){
      MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
      String className = methodSignature.getDeclaringType().getSimpleName();
      String methodName = methodSignature.getName();
      logger.info("Start " + className + "." + methodName);
   }

   @AfterReturning("execution(* com.example.demo.Controller..*(..))")
   public void ControllerDone(JoinPoint joinPoint){
      MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
      String className = methodSignature.getDeclaringType().getSimpleName();
      String methodName = methodSignature.getName();
      logger.info(className + "." + methodName + " Done");
   }

   @AfterReturning("within(com.example.demo.Controller..*)")
   public void ControllerDone1(JoinPoint joinPoint){
      MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
      String className = methodSignature.getDeclaringType().getSimpleName();
      String methodName = methodSignature.getName();
      logger.info(className + "." + methodName + " Done");
   }

}
