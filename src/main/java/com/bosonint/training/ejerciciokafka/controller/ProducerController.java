package com.bosonint.training.ejerciciokafka.controller;

import com.bosonint.training.ejerciciokafka.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class ProducerController {


    @Autowired
    KafkaProducer kafkaProducer;

    @PostMapping("/post/{topic}")
    public  void publishMessage(@PathVariable String topic ,@RequestBody String message){
        kafkaProducer.sendMessage(topic,message);
    }

//    @PostMapping("/obj")
//    public String publishObject(@RequestBody String obj){
//        return kafkaProducer.sendMessage(obj);
//    }
}
