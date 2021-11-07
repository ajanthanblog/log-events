package com.wso2.apim.log.logevents.counter;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.wso2.am.analytics.publisher.exception.MetricReportingException;
import org.wso2.am.analytics.publisher.reporter.CounterMetric;
import org.wso2.am.analytics.publisher.reporter.MetricEventBuilder;
import org.wso2.am.analytics.publisher.reporter.MetricSchema;
import org.wso2.am.analytics.publisher.reporter.cloud.DefaultResponseMetricEventBuilder;

import java.util.Map;

@Slf4j
@AllArgsConstructor
public class LogEventCounterMetric implements CounterMetric {

    private String name;
    private MetricSchema schema;

    @Override
    public int incrementCount(MetricEventBuilder metricEventBuilder) {
        Map<String, Object> properties = null;
        try {
            properties = metricEventBuilder.build();
            log.info("{{}} {{}} {}", properties.get("apiName").toString().replaceAll("[\r\n]",""), properties.get("correlationId").toString().replaceAll("[\r\n]",""), properties.toString().replaceAll("[\r\n]", ""));
        } catch (MetricReportingException e) {
            log.error("Error Occurred while Publishing data: {}", e.getMessage());
        }
        return 0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public MetricSchema getSchema() {
        return this.schema;
    }

    @Override
    public MetricEventBuilder getEventBuilder() {
        return new DefaultResponseMetricEventBuilder();
    }

}
