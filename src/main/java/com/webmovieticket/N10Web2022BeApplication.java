package com.webmovieticket;

import io.prometheus.client.Counter;
import io.prometheus.client.Gauge;
import io.prometheus.client.Histogram;
import io.prometheus.client.Summary;
import io.prometheus.metrics.instrumentation.jvm.JvmMetrics;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class N10Web2022BeApplication {
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(N10Web2022BeApplication.class, args);
//		JvmMetrics.builder().register();

	}

}
