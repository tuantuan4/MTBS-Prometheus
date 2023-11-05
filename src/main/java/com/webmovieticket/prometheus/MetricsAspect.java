package com.webmovieticket.prometheus;
//
//import io.prometheus.client.Counter;
//import io.prometheus.client.Gauge;
//import io.prometheus.client.Histogram;
//import io.prometheus.client.Summary;
//import lombok.extern.apachecommons.CommonsLog;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import java.util.Arrays;
//
//import static java.lang.String.valueOf;
//
//@Aspect
//@Component
//public class MetricsAspect {
//    @Autowired
//    private Counter restApiCounter;
//
//    @Autowired
//    private Gauge restApiGauge;
//
//    @Autowired
//    private Histogram restApiHistogram;
//
//    @Autowired
//    private Summary restApiSummary;
//
//    @Before("execution(* com.webmovieticket.controller.*.*(..))")
//    public void beforeRequest(JoinPoint joinPoint) {
//        Object[] args = joinPoint.getArgs();
//
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        String method = attributes.getRequest().getMethod();
//        String path = attributes.getRequest().getRequestURI();
//        int status = attributes.getResponse().getStatus();
//        // Ghi các chỉ số vào các metric
//        restApiCounter.labels(method, path, valueOf(status)).inc();
////        restApiGauge.set(1024);
//    }
//
//    @After("execution(* com.webmovieticket.controller.*.*(..))")
//    public void afterRequest(JoinPoint joinPoint) {
//        Object[] args = joinPoint.getArgs();
//
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//
//        String method = attributes.getRequest().getMethod();
//        String path = attributes.getRequest().getRequestURI();
//        int status = attributes.getResponse().getStatus();
//        restApiCounter.labels(method,path, valueOf(status)).inc();
//        restApiGauge.labels(method, path, valueOf(status)).set(1024);
//
//        Histogram.Timer start = restApiHistogram. labels(method, path, valueOf(status)).startTimer();
//        try {
//
//        } finally {
//            start.observeDuration();
//        }
//
//        // Đo lường thời gian xử lý
////        long duration = System.currentTimeMillis() - Long.parseLong(attributes.getRequest().getAttribute("startTime").toString());
////        restApiHistogram.labels(/* method, path, status */).observe(duration / 1000.0);
////        restApiSummary.labels(/* method, path, status */).observe(duration / 1000.0);
//    }
//}
