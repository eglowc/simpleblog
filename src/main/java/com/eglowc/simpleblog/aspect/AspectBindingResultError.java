package com.eglowc.simpleblog.aspect;

import com.eglowc.simpleblog.web.error.BindingResultErrorUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.util.Arrays;

/**
 * @author eglowc<eglowc@gmail.com>
 */
@Component
@Aspect
@Slf4j
public class AspectBindingResultError {

    @Pointcut("execution(* com..*Controller.*(..))")
    public void methodInControllers() {
    }

    @Pointcut("args(*, result, ..)")
    public void hasBindingResultArg(BindingResult result) {
    }

    @Before("methodInControllers() && hasBindingResultArg(result)")
    public void aspectCheckBindingResultError(JoinPoint joinPoint, BindingResult result) {
        Arrays.stream(joinPoint.getArgs())
                .filter(arg -> arg instanceof BindingResult)
                .findFirst()
                .map(arg -> (BindingResult) arg)
                .ifPresent(BindingResultErrorUtil::checkBindingResultError);
    }

}
