/*
package com.fankf.springmvc.kafka;

import com.fankf.springmvc.util.SpringBeanUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;

@Component
@Slf4j
public class KafkaInitRunner implements ApplicationRunner {
    private final static String LOGGER_MSG = "(Kafka监听启动类)";

    @Autowired
    KafkaTopicService topicService;
//    @Autowired
//    KafkaListenMessageHandler kafkaInvoiceHandler;
//    @Autowired
//    KafkaConsumer kafkaConsumer;

    public static ExecutorService executorService = Executors.newFixedThreadPool(6);

    @Override
    public void run(ApplicationArguments args) {


        log.info("{}监听服务启动!", LOGGER_MSG);
        topicService.createTopic("k-a");
        boolean result = true;

        executorService.execute(() -> {
            KafkaListenMessageHandler kafkaListenMessageHandler = SpringBeanUtils.getBean(KafkaListenMessageHandler.class);
            kafkaListenMessageHandler.onMessage(SpringBeanUtils.getBean("kafkaConsumer"), Arrays.asList("k-a"));
        });
        executorService.execute(() -> {
            KafkaListenMessageHandler kafkaListenMessageHandler = SpringBeanUtils.getBean("kafkaInvoiceHandler");
            kafkaListenMessageHandler.onMessage(SpringBeanUtils.getBean("kafkaConsumer"), Arrays.asList("k-b"));
        });
        log.info("--->>>><<<<<<<<<<<<<<<<<<-----");

//        new Thread(() -> kafkaListenMessageHandler.onMessage(kafkaConsumer,Arrays.asList("k-b"))).start();

        if (result) {
            log.info("{}监听服务启动成功!", LOGGER_MSG);
        } else {
            log.error("{}监听服务启动失败!", LOGGER_MSG);
        }
    }
}
*/
