//package com.webmovieticket.controller;
//
//import io.prometheus.client.CollectorRegistry;
//import io.prometheus.client.exporter.common.TextFormat;
//import io.prometheus.metrics.instrumentation.jvm.JvmMetrics;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.io.IOException;
//import java.io.Writer;
//
//@RestController
//public class PrometheusController {
//    @RequestMapping(path = "/metrics")
//    public void metrics(Writer ressponseWriter) throws IOException {
//        TextFormat.write004(ressponseWriter, CollectorRegistry.defaultRegistry.metricFamilySamples());
//        ressponseWriter.close();
////        JvmMetrics.builder().register();
//    }
//}
