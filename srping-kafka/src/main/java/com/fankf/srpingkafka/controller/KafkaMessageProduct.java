package com.fankf.srpingkafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaMessageProduct {
    public static final String topic = "kafka-study";

    @Autowired
    KafkaTemplate kafkaTemplate;
    public void send(String message){
        kafkaTemplate.send(topic,message);
    }
}
