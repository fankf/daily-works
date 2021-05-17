package com.fankf.springkafka.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("send")
@Slf4j
public class KafkaMessageProduct {
    @Autowired
    KafkaTemplate kafkaTemplate;

    @RequestMapping("/{topic}/{message}")
    public void send(@PathVariable("topic") String topic, @PathVariable("message") String message) {
        log.info("topic {} 发送消息 {}", topic, message);
        kafkaTemplate.send(topic, message);
    }

}