package io.meshk.k8s.springk8s.controller;

import io.meshk.k8s.springk8s.metrics.MxError;
import io.meshk.k8s.springk8s.metrics.MxEvent;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class PublishController {
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;


    @Value("${spring.kafka.topic}")
    String TOPIC;

    // Publish messages using the GetMapping
    @GetMapping("/publish/{message}")
    public String publishMessage(@PathVariable("message") final String message) {

        log.info("Just a simple line of log!");

        String transformed = getProcessed(message);

        try {
            kafkaTemplate.send(TOPIC, transformed);
            MDC.put(MxEvent.STATUS, MxEvent.SUCCESS); // To send additional info to the logger
        } catch (Exception ex) {
            MDC.put(MxEvent.STATUS, MxEvent.FAILURE); MDC.put(MxError.MESSAGE, ex.getMessage()); // To send additional info to the logger
        }

        return "done";

    }

    private String getProcessed(String message) {
        log.info("message processed successfully!");
        return message + "_" + "_passed_through_publisher";

    }
}
