package com.webmovieticket.opentelemetry;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.metrics.LongCounter;
import io.opentelemetry.api.metrics.Meter;

import static java.lang.String.valueOf;

public class TotalCounter {
    private final LongCounter httpRequestCounter;
    private TotalCounter(Meter meter) {
        httpRequestCounter = meter
                .counterBuilder("http_request_total")
                .setDescription("Total number of HTTP requests")
                .setUnit("1")
                .build();
    }

    public void increment(String path, String method, String status) {
        Attributes attributesOfLabels = Attributes.of(
                AttributeKey.stringKey("path"), path,
                AttributeKey.stringKey("status"), valueOf(status),
                AttributeKey.stringKey("method"), method);
        httpRequestCounter.add(1, attributesOfLabels);
    }

    public static TotalCounter create(Meter meter) {
        return new TotalCounter(meter);
    }
}
