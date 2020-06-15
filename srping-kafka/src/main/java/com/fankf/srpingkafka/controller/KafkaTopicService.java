package com.fankf.srpingkafka.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.*;
import org.apache.kafka.common.KafkaFuture;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("topic")
@Slf4j
public class KafkaTopicService {

    public static final String CLASS_NAME = "(KafkaTopicService)";

    @Value("${kafka.init.partition}")
    private int partition;
    @Value("${kafka.init.replication-ractor}")
    private short replicationRactor;

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootStrapServers;

    private static AdminClient adminClient = null;

    private AdminClient adminClient() {
        if (adminClient == null) {
            Map<String, Object> map = new HashMap<>();
            map.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootStrapServers);
            adminClient = AdminClient.create(map);
        }
        return adminClient;

    }

    /**
     * create topic in the cluster
     *
     * @param topicName
     */
    @GetMapping("/create/{topicName}")
    public void createTopic(@PathVariable("topicName") String topicName) {
        List<String> collect = listAllTopics().stream().filter(topic -> topic.equals(topicName)).collect(Collectors.toList());

        if (collect.size() == 1) {
            log.error("{} ==> 此 TOPIC 已存在！", CLASS_NAME);
        }
        NewTopic newTopic = new NewTopic(topicName, 3, replicationRactor);
        CreateTopicsResult ret = this.adminClient().createTopics(Arrays.asList(newTopic));
        Map<String, KafkaFuture<Void>> values = ret.values();
        for (String key : values.keySet()) {
            log.info("{} ==> 创建 topic 返回结果 {} ", CLASS_NAME, values.get(key));
        }

    }

    /**
     * print all topics in the cluster
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @GetMapping("/list")
    public Set<String> listAllTopics() {
        ListTopicsOptions options = new ListTopicsOptions();
        options.listInternal(true); // includes internal topics such as __consumer_offsets
        ListTopicsResult topics = this.adminClient().listTopics(options);
        Set<String> topicNames = new HashSet<>();
        try {
            topicNames = topics.names().get();
            log.info("{} ==> Current topics in this cluster: {} ", CLASS_NAME, topicNames);
        } catch (InterruptedException e) {
            log.error("{} ==> listAllTopics 异常信息：{}", CLASS_NAME, e);
            e.printStackTrace();
        } catch (ExecutionException e) {
            log.error("{} ==> listAllTopics 异常信息：{}", CLASS_NAME, e);
            e.printStackTrace();
        }
        return topicNames;

    }

    /**
     * delete the given topics
     * <p>
     * 删除topic的时候必须在 server.properties 添加
     * delete.topic.enable=true
     */
    @GetMapping("/delete/{topicName}")
    public void deleteTopics(@PathVariable("topicName") String topicName) {
        KafkaFuture<Void> futures = this.adminClient().deleteTopics(Arrays.asList(topicName)).all();
        try {
            log.info("{} ==> Current topics in this cluster: {} ", CLASS_NAME, futures.get());
        } catch (InterruptedException e) {
            log.error("{} ==> deleteTopics 异常信息：{}", CLASS_NAME, e);
            e.printStackTrace();
        } catch (ExecutionException e) {
            log.error("{} ==> deleteTopics 异常信息：{}", CLASS_NAME, e);
            e.printStackTrace();
        }
    }

}
