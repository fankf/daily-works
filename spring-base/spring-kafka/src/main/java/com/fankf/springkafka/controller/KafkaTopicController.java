package com.fankf.springkafka.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("topic")
@Slf4j
public class KafkaTopicController {
    @Resource
    RestTemplate restTemplate;
    @Autowired
    AdminClient adminClient;

    @GetMapping("/create/{topicName}")
    public String createTopic(@PathVariable("topicName") String topicName) throws ExecutionException, InterruptedException {
        boolean exist = listAllTopics().stream().allMatch(t0 -> t0.equals(topicName));
        if (exist) {
            log.error("{} ==> 此 TOPIC 已存在！", topicName);
        }
        NewTopic newTopic = new NewTopic(topicName, 1, (short) 0);
        adminClient.createTopics(Arrays.asList(newTopic));
        return null;
    }

    @PostMapping("/list")
    public Set<String> listAllTopics() throws ExecutionException, InterruptedException {
        ListTopicsOptions options = new ListTopicsOptions();
        options.listInternal(true);
        ListTopicsResult listTopicsResult = adminClient.listTopics(options);
        Collection<TopicListing> topicListings = listTopicsResult.listings().get();
        return null;
    }

    @PostMapping("/delete/{topicName}")
    public Set<String> delete(@PathVariable String topicName) throws ExecutionException, InterruptedException {
        ListTopicsOptions options = new ListTopicsOptions();
        options.listInternal(true);
        DeleteTopicsResult deleteTopicsResult = adminClient.deleteTopics(Arrays.asList(topicName));
        deleteTopicsResult.all().get();
        return null;
    }
}
