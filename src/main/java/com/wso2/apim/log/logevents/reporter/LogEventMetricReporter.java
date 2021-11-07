package com.wso2.apim.log.logevents.reporter;

import com.wso2.apim.log.logevents.counter.LogEventCounterMetric;
import lombok.extern.slf4j.Slf4j;
import org.wso2.am.analytics.publisher.exception.MetricCreationException;
import org.wso2.am.analytics.publisher.reporter.CounterMetric;
import org.wso2.am.analytics.publisher.reporter.MetricReporter;
import org.wso2.am.analytics.publisher.reporter.MetricSchema;
import org.wso2.am.analytics.publisher.reporter.TimerMetric;

import java.util.Map;

@Slf4j
public class LogEventMetricReporter implements MetricReporter {

    public LogEventMetricReporter(Map<String, String> properties) {
        log.info("Successfully Initialized LogEventMetricReporter");
    }

    @Override
    public CounterMetric createCounterMetric(String name, MetricSchema metricSchema) throws MetricCreationException {
        log.info("Invoking createCounterMetric");
        return new LogEventCounterMetric(name, metricSchema);
    }

    @Override
    public TimerMetric createTimerMetric(String s) {
        return null;
    }

    @Override
    public Map<String, String> getConfiguration() {
        return null;
    }
}
