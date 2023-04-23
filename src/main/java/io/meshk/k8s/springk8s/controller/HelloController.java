package io.meshk.k8s.springk8s.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@Slf4j
@RestController // marks the class as a controller
@RequestMapping("/app") // Root path to the API endpoints in this class
public class HelloController {

    @GetMapping (value = "/hello")// Get request that returns all students
    public ResponseEntity<String> getAll() throws InterruptedException {
        //StopWatch stopWatch = new StopWatch(); stopWatch.start();
        //Random random = new Random();
        //Thread.sleep(random.nextInt(2000 - 300 + 1000) + 300);
        //stopWatch.stop();
        //log.info(metrics.responseTime(this.getClass().getSimpleName()+"."+Thread.currentThread().getStackTrace()[1].getMethodName(), stopWatch));
        log.info("/hello called");
        return new ResponseEntity<>("Hello!", HttpStatus.OK);
    }


    @GetMapping  (value = "/tran")// Get request that returns all students
    public ResponseEntity<String> consume() throws InterruptedException {
//        StopWatch stopWatch = new StopWatch(); stopWatch.start();
//        Random random = new Random();
        //Thread.sleep(random.nextInt(2000 - 300 + 1000) + 800);
//        stopWatch.stop();
        //log.info(metrics.totalTransaction(this.getClass().getSimpleName()+"."+Thread.currentThread().getStackTrace()[1].getMethodName(), random.nextInt(500), stopWatch));
        return new ResponseEntity<>("Processed!", HttpStatus.OK);
    }

}