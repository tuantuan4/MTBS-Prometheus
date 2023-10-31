package com.webmovieticket.configuration;


import io.prometheus.client.Gauge;
import io.prometheus.client.Histogram;
import io.prometheus.client.Summary;
import io.prometheus.client.Counter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@Configuration
public class PrometheusConfiguration {
    @Bean
    public Counter restApiCounter() {
        return Counter.build()
                .name("rest_api_requests_total")
                .help("Total number of REST API requests")
//                .unit(String.valueOf(Unit.SECONDS))
                .labelNames("method", "path", "status")
                .register();
    }
    @Bean
    public Counter httpExceptionCounter() {
        return Counter.build()
                .name("http_request_exceptions_total")
                .help("Total number of HTTP request exceptions")
                .labelNames("method", "path")
                .register();
    }
    @Bean
    public Gauge restApiGauge() {
        return Gauge.build()
                .name("rest_api_response_size_bytes")
                .help("Size of REST API responses in bytes")
                .labelNames("method", "path", "status")
                .register();
    }

    @Bean
    public Histogram restApiHistogram() {
        return Histogram.build()
                .name("rest_api_request_duration_seconds")
                .help("Duration of REST API requests in seconds")
                .labelNames("method", "path", "status")
                .register();
    }

    @Bean
    public Summary restApiSummary() {
        return Summary.build()
                .name("rest_api_response_time_seconds")
                .help("Time taken for REST API responses in seconds")
                .labelNames("method", "path", "status")
                .register();
    }
}