/*
package com.fankf.springmvc.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

*/
/**
 * 发送消息
 *//*

@RestController
@Slf4j
public class KafkaMessageService {

    @Autowired
    private KafkaProducer kafkaProducer;

    @RequestMapping("/send/{topic}/{message}")
    public String sendMessage(@PathVariable("topic") String topic, @PathVariable("message") String message) {
        asynSendRecord(topic, message);
        return message;
    }

    //异步发送消息
    public void asynSendRecord(String topic, Object message) {
        ProducerRecord<String, Object> record = new ProducerRecord<>(topic, message);
        log.info("record:" + record.value());
        kafkaProducer.send(record, (recordMetadata, e) -> {
            if (e == null) {
                log.info("消息发送: offset: {} timestamp:{}  topic:{}  partition: {} ", recordMetadata.offset(), recordMetadata.timestamp(), recordMetadata.topic(), recordMetadata.partition());
                log.info("消息发送成功");
            } else {
                log.error(String.format("消息发送失败: {}", e.getMessage()));
            }
        });

//        kafkaProducer.close();
    }
}
*/
