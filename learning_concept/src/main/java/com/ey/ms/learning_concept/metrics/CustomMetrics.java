package com.ey.ms.learning_concept.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomMetrics {

    private final Counter customCounter;

    @Autowired
    public CustomMetrics(MeterRegistry meterRegistry){
        this.customCounter=Counter.builder("custom.metric.counter")
                .description("A custom counter metric")
                .register(meterRegistry);
    }

    public void incrementCounter(){
        this.customCounter.increment();
    }
}
