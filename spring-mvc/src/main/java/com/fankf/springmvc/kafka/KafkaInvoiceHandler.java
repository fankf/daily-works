package com.fankf.springmvc.kafka;

import com.fankf.springmvc.util.SpringBeanUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.sql.PseudoColumnUsage;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 开票业务监听
 *
 * @author ZSC-DXHY
 */
@Component
@Scope("prototype")
@Slf4j
public class KafkaInvoiceHandler {
    private final static String LOGGER_MSG = "(开票业务监听)";

    @Autowired
    private KafkaMessageService kafkaMessageService;

    /**
     * 监听数据
     *
     * @param topic
     */
    public void onMessage(KafkaConsumer kafkaConsumer, List<String> topic) {
        kafkaConsumer.subscribe(topic);
        log.info("队列开始监听：topic {}", topic);
        try {
            while (true) {
                ConsumerRecords<String, String> records = kafkaConsumer.poll(1000);
                for (ConsumerRecord<String, String> record : records) {
                    log.info("partition:{} offset = {}, key = {}, value = {}",record.partition(), record.offset(), record.key(), record.value());
                    try {


                        String messageData = new String(record.value().getBytes(), StandardCharsets.UTF_8);
                        log.info("{}解析处理内容为:{}", LOGGER_MSG, messageData);
                        reverse(record.topic(), messageData);
                        Thread.sleep(5000);
                    } catch (Exception e) {
                        log.error("消息处理异常");
                    }
//                    kafkaConsumer.commitSync();
                }
            }
        } finally {
            kafkaConsumer.close();
        }
    }


    /**
     * 业务处理
     *
     * @param message
     */
    private void reverse(String topic, String message) {
        switch (topic) {
            case "k-a": // 发票开具推送企业
                log.info("k-a aaaaaaaaaaaaaaaaaa message:{}", message);
                break;
            case "k-b": // 轮询开票
                log.info("k-b bbbbbbbbbbbbbbbbbb message:{}", message);
                break;
        }

    }

}
