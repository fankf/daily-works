package com.fankf.springkafka.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.ListTopicsOptions;
import org.apache.kafka.clients.admin.ListTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Set;

@RestController
@RequestMapping("topic")
@Slf4j
public class KafkaTopicController {

    @Autowired
    AdminClient adminClient;

    @GetMapping("/create/{topicName}")
    public String createTopic(@PathVariable("topicName") String topicName) {
        boolean exist = listAllTopics().stream().allMatch(t0 -> t0.equals(topicName));
        if (exist) {
            log.error("{} ==> 此 TOPIC 已存在！", topicName);
        }
        NewTopic newTopic = new NewTopic(topicName, 1, (short) 0);
        adminClient.createTopics(Arrays.asList(newTopic));
        return null;
    }

    @PostMapping("/list")
    public Set<String> listAllTopics() {
        ListTopicsOptions options = new ListTopicsOptions();
        options.listInternal(true);
        ListTopicsResult listTopicsResult = adminClient.listTopics(options);
        listTopicsResult.listings();
        return null;
    }
}
