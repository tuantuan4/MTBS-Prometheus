package com.webmovieticket.opentelemetry;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.metrics.LongHistogram;
import io.opentelemetry.api.metrics.Meter;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static java.lang.String.valueOf;

public class DurationHistogram {
    private final LongHistogram longHistogram;

    private DurationHistogram(Meter meter) {
        longHistogram = meter
                .histogramBuilder("http_request_duration")
                .ofLongs()
                .setDescription("Duration of HTTP request")
                .setUnit("second")
                .build();
    }

    public void increase(long durationTime, String path, String method, String status) {
        Attributes attributesOfLabels = Attributes.of(
                AttributeKey.stringKey("path"), path,
                AttributeKey.stringKey("status"), valueOf(status),
                AttributeKey.stringKey("method"), method);
        longHistogram.record(durationTime, attributesOfLabels);
    }
    public static DurationHistogram create(Meter meter) {
        return new DurationHistogram(meter);
    }
}
