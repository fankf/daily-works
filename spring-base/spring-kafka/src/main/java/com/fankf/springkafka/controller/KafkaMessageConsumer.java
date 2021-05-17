package com.fankf.springkafka.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Component
@Slf4j
public class KafkaMessageConsumer {

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

}