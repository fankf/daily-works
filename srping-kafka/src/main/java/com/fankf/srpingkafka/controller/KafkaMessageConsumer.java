package com.fankf.srpingkafka.controller;

import com.fankf.srpingkafka.constant.TopicName;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Component
@Slf4j
public class KafkaMessageConsumer {

//    @Autowired
//    KafkaTemplate kafkaTemplate;

    public static final String topic = "kafka-demo";

    @KafkaListener(topics = topic)
    public void consumer(ConsumerRecord consumerRecord) {
        Optional<Object> kafkaMassage = Optional.ofNullable(consumerRecord.value());
        if (kafkaMassage.isPresent()) {
            Object o = kafkaMassage.get();
            log.info(o.toString());
        }
        log.info("offset: {} 收到消息: key === {} ", consumerRecord.offset(), new String(consumerRecord.value().toString().getBytes(), StandardCharsets.UTF_8));

    }

//    @KafkaListener(topicPattern = TopicName.T0)
    public void consumer0(ConsumerRecord consumerRecord) {
        Optional<Object> kafkaMassage = Optional.ofNullable(consumerRecord.value());
        if (kafkaMassage.isPresent()) {
            Object o = kafkaMassage.get();
            log.info(o.toString());
        }
        log.info("offset: {} 收到消息: key ===>>>>>> {} ", consumerRecord.offset(), new String(consumerRecord.value().toString().getBytes(), StandardCharsets.UTF_8));

    }
}
