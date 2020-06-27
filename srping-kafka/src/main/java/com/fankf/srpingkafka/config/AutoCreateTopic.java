package com.fankf.srpingkafka.config;

import com.fankf.srpingkafka.controller.KafkaTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AutoCreateTopic implements ApplicationRunner {

    @Autowired
    KafkaTopicService kafkaTopicService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        kafkaTopicService.createTopic("kafka-demo");
        kafkaTopicService.listAllTopics();
    }
}
