package com.fankf.srpingkafka.config;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
public class KafkaConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootStrapServers;


    @Value("${spring.kafka.bootstrap-servers}")
    private String servers;
    @Value("${spring.kafka.consumer.group-id}")
    private String groupId;
    @Value("${spring.kafka.consumer.auto-commit-interval}")
    private String pollOutTime;
    @Value("${spring.kafka.consumer.max-poll-records}")
    private Integer pollNum;
    @Value("${spring.kafka.consumer.enable-auto-commit}")
    private String autoCommit;
    @Value("${spring.kafka.consumer.auto-offset-reset}")
    private String offsetReset;


    @Bean
    public KafkaConsumer getKafkaConsumer() {
        Properties props = new Properties();
        //kafka消费的的地址
        props.put("bootstrap.servers", servers);
        //组名 不同组名可以重复消费
        props.put("group.id", groupId);
        //是否自动提交
        props.put("enable.auto.commit", autoCommit);
        //从poll(拉)的回话处理时长
        props.put("auto.commit.interval", pollOutTime);
        //一次最大拉取的条数
        props.put("max.poll.records", pollNum);
//      earliest   当各分区下有已提交的offset时，从提交的offset开始消费；无提交的offset时，从头开始消费
//      latest     当各分区下有已提交的offset时，从提交的offset开始消费；无提交的offset时，消费新产生的该分区下的数据
//      none       topic各分区都存在已提交的offset时，从offset后开始消费；只要有一个分区不存在已提交的offset，则抛出异常
        props.put("auto.offset.reset", offsetReset);
        //序列化
        props.put("key.deserializer", StringDeserializer.class.getName());
        props.put("value.deserializer", StringDeserializer.class.getName());
        KafkaConsumer<String,String> kafkaConsumer = new KafkaConsumer<>(props);
        return kafkaConsumer;
    }

    @Bean
    public AdminClient adminClient() {
        Map<String, Object> map = new HashMap<>();
        map.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootStrapServers);
        return AdminClient.create(map);

    }
}
