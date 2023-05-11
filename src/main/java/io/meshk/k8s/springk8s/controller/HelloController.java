package io.meshk.k8s.springk8s.controller;

import io.meshk.k8s.springk8s.metrics.MxEvent;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController // marks the class as a controller
@RequestMapping("/app") // Root path to the API endpoints in this class
public class HelloController {

    @GetMapping (value = "/hello")// Get request that returns all students
    public ResponseEntity<String> getAll() throws InterruptedException {

        MDC.put(MxEvent.ACTION, MxEvent.HTTP_GET);

        log.info("/hello called");

        return new ResponseEntity<>("Hello!", HttpStatus.OK);
    }


}