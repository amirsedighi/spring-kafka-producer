package io.meshk.k8s.springk8s.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class PublishController {
    @Autowired KafkaTemplate<String, String> kafkaTemplate;

    @Value("${spring.kafka.topic}")
    String TOPIC;

    // Publish messages using the GetMapping
    @GetMapping("/publish/{message}")
    public String publishMessage(@PathVariable("message")
                                 final String message)
    {
        // Sending the message
        kafkaTemplate.send(TOPIC, message);

        return "Published Successfully";
    }
}
