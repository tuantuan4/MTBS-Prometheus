package com.webmovieticket.opentelemetry;

import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@Aspect
@Component
public class MetricsAspect {
    private ThreadLocal<Long> startTime = new ThreadLocal<>();
    private final TotalCounter totalCounter;
    private final DurationHistogram durationHistogram;

    @Autowired Tracer tracer;
    public MetricsAspect(TotalCounter totalCounter, DurationHistogram durationHistogram) {
        this.totalCounter = totalCounter;
        this.durationHistogram = durationHistogram;
    }

    @Before("execution(* com.webmovieticket.controller.*.*(..))")
    public void beforeRequest(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        startTime.set(System.currentTimeMillis());
    }

//    @After("execution(* com.webmovieticket.controller.*.*(..))")
//    public void afterRequest(JoinPoint joinPoint) {
//        Object[] args = joinPoint.getArgs();
//
//        long endTime = System.currentTimeMillis();
//        totalCounter.increment();
//        durationHistogram.increase(endTime - startTime.get());
//    }

    @AfterReturning(value = "execution(* com.webmovieticket.controller.*.*(..))", returning = "result")
    public void afterReturning(Object result) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        String method = attributes.getRequest().getMethod();
        String path = attributes.getRequest().getRequestURI();
        String statusCode = result.toString().substring(1, 4);
        Span span = tracer.spanBuilder("test1").startSpan();
        span.setAttribute("Method", method);
        span.setAttribute("Path", path);
        span.setAttribute("Status_Code", statusCode);
        span.end();

        long endTime = System.currentTimeMillis();
        totalCounter.increment(path, method, statusCode);
        durationHistogram.increase(endTime - startTime.get(), path, method, statusCode);
//        System.out.println("Giá trị trả về của hàm: " + result.toString().substring(1, 4));
    }
}
