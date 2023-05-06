package io.meshk.k8s.springk8s.metrics;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Metrics {

    public final String  KAFKA_READ = "KAFKA_READ";
    public final String  KAFKA_WRITE = "KAFKA_WRITE";

    public final String  HTTP_GET = "HTTP_GET";


    @Value("${metrics.service.namespace}")
    String namespace;

    @Value("${metrics.tagged.version:1}")
    String metricsFriendlyVersion;

    @Value("${metrics.service.project}")
    String project;

    @Value("${spring.application.name}")
    String serviceName;

    public String getTotal(Integer total){
        return " [metrics.total=" + total + "]";
    }

    public String getAction(String action){
        return " [metrics.action=" + action + "]";
    }

    public String getNS(){
        return " [metrics.service.namespace=" + namespace + "]";
    }

    public String getProject(){
        return " [metrics.service.project=" + project + "]";
    }

    public String getMetricsFriendly(){
        return " [metrics.tagged.version=" + metricsFriendlyVersion + "]";
    }

    public String getStatus(boolean status){
        return " [metrics.status=" + (status?"SUCCESS":"FAILED") + "]";
    }

    public String decorate(String action, Boolean success){
        return getMetricsFriendly() + getProject() + getNS() + getAction(action) + getStatus(success);
    }

}
