package com.fankf.srpingkafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaMessageProduct {
    public static final String topic = "kafka-study";

    @Autowired
    KafkaTemplate kafkaTemplate;

    @RequestMapping
    public void send(String message) {
        kafkaTemplate.send(topic, message);
    }
}
