package com.fankf.srpingkafka.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("send")
@Slf4j
public class KafkaMessageProduct {
    public static final String topic = "kafka-study";

    @Autowired
    KafkaTemplate kafkaTemplate;
    @Autowired
    KafkaConsumer consumer;

    @RequestMapping("/{topic}/{message}")
    public void send(@PathVariable("topic") String topic, @PathVariable("message") String message) {
        log.info("topic {} 发送消息 {}", topic, message);
        kafkaTemplate.send(topic, message);
    }

    @RequestMapping("c")
    public KafkaConsumer kafkaConsumer() {
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(1000);
            records.forEach((ConsumerRecord<String, String> record) -> {
                log.info("收到消息: key ===" + new String(record.key().getBytes(), StandardCharsets.UTF_8)
                        + " value ====" + new String(record.value().getBytes(), StandardCharsets.UTF_8)
                        + " topic ===" + new String(record.topic().getBytes(), StandardCharsets.UTF_8));
            });

        }
    }
}
