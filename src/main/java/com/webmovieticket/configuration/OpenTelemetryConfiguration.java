package com.webmovieticket.configuration;

import com.webmovieticket.opentelemetry.DurationHistogram;
import com.webmovieticket.opentelemetry.TotalCounter;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.metrics.Meter;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.exporter.logging.LoggingMetricExporter;
import io.opentelemetry.exporter.logging.LoggingSpanExporter;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.logs.SdkLoggerProvider;
import io.opentelemetry.sdk.logs.export.BatchLogRecordProcessor;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.export.PeriodicMetricReader;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.export.SimpleSpanProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenTelemetryConfiguration {

    /**
     * Manual Configuration.
     * @return
     */
    @Bean
    public OpenTelemetry openTelemetry() {

        SdkMeterProvider sdkMeterProvider = SdkMeterProvider.builder()
                .registerMetricReader(PeriodicMetricReader.builder(LoggingMetricExporter.create()).build())
                .build();
        SdkLoggerProvider sdkLoggerProvider = SdkLoggerProvider.builder()
                .addLogRecordProcessor(BatchLogRecordProcessor.builder(SystemOutLogRecordExporter.create()).build())
                .build();
        SdkTracerProvider sdkTracerProvider = SdkTracerProvider.builder()
                .addSpanProcessor(SimpleSpanProcessor.create(LoggingSpanExporter.create()))
                .build();
        OpenTelemetry openTelemetry = OpenTelemetrySdk.builder()
            .setMeterProvider(sdkMeterProvider)
            .setLoggerProvider(sdkLoggerProvider)
            .setTracerProvider(sdkTracerProvider)
            .buildAndRegisterGlobal();
        return openTelemetry;
    }

    /**
     * Automatic Configuration
     * @param openTelemetry
     * @return
     */
//    @Bean
//    public OpenTelemetry openTelemetry() {
//        return AutoConfiguredOpenTelemetrySdk.initialize().getOpenTelemetrySdk();
//    }
    @Bean
    public Meter meter(OpenTelemetry openTelemetry) {
        return openTelemetry.getMeter("com.webmovieticket.controller");
    }
    @Bean
    public Tracer tracer(OpenTelemetry openTelemetry) {
        return openTelemetry.getTracer("com.webmovieticket.controller");
    }
    @Bean
    public TotalCounter totalCounter(Meter meter) {
        return TotalCounter.create(meter);
    }
    @Bean
    public DurationHistogram durationHistogram(Meter meter) {
        return DurationHistogram.create(meter);
    }
}
