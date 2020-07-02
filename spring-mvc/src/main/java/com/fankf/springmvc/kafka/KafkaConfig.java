package com.fankf.springmvc.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 获取kafka consumer
 */
@Configuration
@Slf4j
public class KafkaConfig {

    @Value("${kafka.bootstrap-servers}")
    private String servers;
    @Value("${kafka.session-out}")
    private String sessionOut;
    @Value("${kafka.retry}")
    private int retry;
    @Value("${kafka.batch-size}")
    private int batchSize;
    @Value("${kafka.buffer-memory}")
    private String bufferMemory;
    @Value("${kafka.password}")
    private String kafkaPassword;
    @Value("${kafka.username}")
    private String kafkaUserName;
    @Value("${kafka.enable.auto.commit}")
    private String enableAutoCommit;

    //    --------------consumer-----------------
    @Value("${kafka.consumer-groupId}")
    private String groupId;
    @Value("${kafka.auto-commit-interval}")
    private String autoCommitInterval;

    @Bean
    @Scope("prototype")
    public KafkaConsumer kafkaConsumer() {
        Properties props = new Properties();
        props.put("bootstrap.servers", servers);
        props.put("group.id", groupId);
        props.put("auto.commit.interval.ms", autoCommitInterval);
        props.put("session.timeout.ms", sessionOut);
        if (!StringUtils.isEmpty(kafkaUserName) && !StringUtils.isEmpty(kafkaPassword)) {
            props.put("sasl.jaas.config",
                    "org.apache.kafka.common.security.plain.PlainLoginModule required username=" + kafkaUserName + " password=" + kafkaPassword + ";");
            props.put("authorizer.class.name", "kafka.security.auth.SimpleAclAuthorizer");
            props.put("security.protocol", "SASL_PLAINTEXT");
            props.put("sasl.mechanism", "PLAIN");
        }

        props.put("enable.auto.commit", "true");
        props.put("auto.offset.reset", "earliest");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        return new KafkaConsumer(props);
    }

    @Bean
    public KafkaProducer kafkaProducer() {
        Properties props = new Properties();
        props.put("bootstrap.servers", servers);
        props.put("session.timeout.ms", sessionOut);
        props.put("retries", retry);
        props.put("buffer.memory", bufferMemory);
        props.put("batch.size", batchSize);
        if (!StringUtils.isEmpty(kafkaUserName) && !StringUtils.isEmpty(kafkaPassword)) {
            props.put("sasl.jaas.config",
                    "org.apache.kafka.common.security.plain.PlainLoginModule required username=" + kafkaUserName + " password=" + kafkaPassword + ";");
            props.put("security.protocol", "SASL_PLAINTEXT");
            props.put("sasl.mechanism", "PLAIN");
            props.put("authorizer.class.name", "kafka.security.auth.SimpleAclAuthorizer");
        }

        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("acks", "1");
        props.put("linger.ms", 10);
        props.put("max.block.ms", 3000);
        return new KafkaProducer(props);

    }

}
