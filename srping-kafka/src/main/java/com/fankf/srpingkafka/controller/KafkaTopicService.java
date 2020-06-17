package com.fankf.srpingkafka.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.*;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.KafkaFuture;
import org.apache.kafka.common.Node;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.TopicPartitionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("topic")
@Slf4j
public class KafkaTopicService {

    public static final String CLASS_NAME = "(KafkaTopicService)";

    @Value("${kafka.init.partition}")
    private int partition;
    @Value("${kafka.init.replication-ractor}")
    private short replicationRactor;

    @Autowired
    private AdminClient adminClient;
    @Autowired
    private KafkaConsumer consumer;


    /**
     * create topic in the cluster
     *
     * @param topicName
     */
    @GetMapping("/create/{topicName}")
    public void createTopic(@PathVariable("topicName") String topicName) {
        boolean exist = listAllTopics().stream().allMatch(topic -> topic.equals(topicName));

        if (exist) {
            log.error("{} ==> 此 TOPIC 已存在！", CLASS_NAME);
        }
        NewTopic newTopic = new NewTopic(topicName, 3, replicationRactor);
        CreateTopicsResult ret = adminClient.createTopics(Arrays.asList(newTopic));
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
        ListTopicsResult topics = adminClient.listTopics(options);
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
        KafkaFuture<Void> futures = adminClient.deleteTopics(Arrays.asList(topicName)).all();
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


    /**
     * 查看就近 N 条信息
     * describe the given topics
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @GetMapping("/descr/{name}/{num}")
    public void describeTopics(@PathVariable("name") String topicName, @PathVariable("num") int num) throws ExecutionException, InterruptedException {

        DescribeTopicsResult ret = adminClient.describeTopics(Arrays.asList(topicName));
        Map<String, KafkaFuture<TopicDescription>> values = ret.values();
        Iterator<Map.Entry<String, KafkaFuture<TopicDescription>>> iterator = values.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, KafkaFuture<TopicDescription>> next = iterator.next();
            log.info("entity key :{}", next);

            List<TopicPartitionInfo> partitions = next.getValue().get().partitions();
            for (TopicPartitionInfo e : partitions) {
                int partitionId = e.partition();
                Node node = e.leader();

                TopicPartition topicPartition = new TopicPartition(topicName, partitionId);
                // partition
                Map<TopicPartition, Long> mapBeginning = consumer.beginningOffsets(Arrays.asList(topicPartition));
                Iterator<Map.Entry<TopicPartition, Long>> itr2 = mapBeginning.entrySet().iterator();
                long beginOffset = 0;
                //mapBeginning只有一个元素，因为Arrays.asList(topicPartition)只有一个topicPartition
                while (itr2.hasNext()) {
                    Map.Entry<TopicPartition, Long> tmpEntry = itr2.next();
                    beginOffset = tmpEntry.getValue();
                }
                Map<TopicPartition, Long> mapEnd = consumer.endOffsets(Arrays.asList(topicPartition));
                Iterator<Map.Entry<TopicPartition, Long>> itr3 = mapEnd.entrySet().iterator();
                long lastOffset = 0;
                while (itr3.hasNext()) {
                    Map.Entry<TopicPartition, Long> tmpEntry2 = itr3.next();
                    lastOffset = tmpEntry2.getValue();
                }
                long expectedOffSet = lastOffset - num;

                expectedOffSet = expectedOffSet > 0 ? expectedOffSet : 1;
                if (expectedOffSet == 0) {
                    num = (int) lastOffset;
                }
                log.info("Leader of partitionId: " + partitionId + "  is " + node + ".  expectedOffSet:" + expectedOffSet
                        + "，  beginOffset:" + beginOffset + ", lastOffset:" + lastOffset);
                consumer.commitSync(Collections.singletonMap(topicPartition, new OffsetAndMetadata(expectedOffSet - 1)));

            }
        }
        consumer.subscribe(Arrays.asList(topicName));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(num);
            for (ConsumerRecord<String, String> record : records) {
                log.info("read offset =%d, key=%s , value= %s, partition=%s\n",
                        record.offset(), record.key(), record.value(), record.partition());
            }
        }
    }

}
