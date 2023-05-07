package io.meshk.k8s.springk8s.controller;

import io.meshk.k8s.springk8s.metrics.Metrics;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class PublishController {
    @Autowired KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    Metrics metrics;

    @Value("${spring.kafka.topic}")
    String TOPIC;

    // Publish messages using the GetMapping
    @GetMapping("/publish/{message}")
    public String publishMessage(@PathVariable("message")
                                 final String message)
    {

        log.info(metrics.decorate(metrics.HTTP_GET, true));

        log.info("This line of log not supposed to be used for metrics purposes. request: {}", message);

        String transformed = getProcessed(message);

        try {
            kafkaTemplate.send(TOPIC, transformed);
            log.info(metrics.decorate(metrics.KAFKA_WRITE, true));
        } catch (Exception ex) {
            log.error(metrics.decorate(metrics.KAFKA_WRITE, false));
        }


        return "done";

    }

    private String getProcessed(String message){

        return  message + "_" + "_passed_through_publisher";

    }
}
