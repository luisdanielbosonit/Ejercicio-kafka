package com.bosonint.training.ejerciciokafka.consumer;

import com.bosonint.training.ejerciciokafka.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Profile("profileConsumer2")
public class KafkaConsumer2 {

    @Autowired
    KafkaProducer kafkaProducer;

    @KafkaListener(topics="${message.topic.name1:topic1}",  groupId = "${message.group.name:group1}")
    public void listen2(String msg){
        System.out.println("recibe mensaje"+msg);
        kafkaProducer.sendMessage("topic","mensaje Recibido: "+msg);
    }

}
