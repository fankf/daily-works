package com.fankf.srpingkafka.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.*;
import org.apache.kafka.common.KafkaFuture;
import org.apache.kafka.common.Node;
import org.apache.kafka.common.config.ConfigResource;

import java.util.*;
import java.util.concurrent.ExecutionException;

@Slf4j
public class KafkaTopicUtil {
    public static final String TEST_TOPIC = "kafka-a";

    /**
     * kafka client 功能
     * <p>
     * 创建topic
     * 查询所有topic
     * 查询单个topic详情
     * 删除topic
     * 修改config（包括BROKER和TOPIC资源的config）
     * 查询资源config详情
     * 创建ACL
     * 查询ACL详情
     * 删除ACL
     * 查询整个集群详情
     * </p>
     *
     * @param args
     */
    public static void main(String[] args) {
        Properties props = new Properties();
//        props.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092,localhost:9093");
        props.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");

        try (AdminClient client = AdminClient.create(props)) {
            //创建 topic
//            createTopics(client);
            // 查询 topic
//            describeTopics(client);
//            //删除 topic
            deleteTopics(client);
//
//            //查询集群
//            describeCluster(client);
//            //消费所有 topic
//            listAllTopics(client);
//
//            //查询 config
//            describeConfig(client);
//            //修改配置 config
//            alterConfigs(client);


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * describe the cluster
     *
     * @param client
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void describeCluster(AdminClient client) throws ExecutionException, InterruptedException {
        DescribeClusterResult ret = client.describeCluster();
        log.info(String.format("Cluster id: %s, controller: %s", ret.clusterId().get(), ret.controller().get()));
        log.info("Current cluster nodes info: ");
        for (Node node : ret.nodes().get()) {
            log.info("------------------------------------>>>>>>>>>>>>>>>>" + node.toString());
        }
    }

    /**
     * describe topic's config
     *
     * @param client
     */
    public static void describeConfig(AdminClient client) throws ExecutionException, InterruptedException {
        DescribeConfigsResult ret = client.describeConfigs(Collections.singleton(new ConfigResource(ConfigResource.Type.TOPIC, TEST_TOPIC)));
        Map<ConfigResource, Config> configs = ret.all().get();
        for (Map.Entry<ConfigResource, Config> entry : configs.entrySet()) {
            ConfigResource key = entry.getKey();
            Config value = entry.getValue();
            log.info(String.format("Resource type: %s, resource name: %s", key.type(), key.name()));
            Collection<ConfigEntry> configEntries = value.entries();
            for (ConfigEntry each : configEntries) {
                log.info(each.name() + " = " + each.value());
            }
        }

    }

    /**
     * alter config for topics
     *
     * @param client
     */
    public static void alterConfigs(AdminClient client) throws ExecutionException, InterruptedException {
        Config topicConfig = new Config(Arrays.asList(new ConfigEntry("cleanup.policy", "compact")));
        client.alterConfigs(Collections.singletonMap(
                new ConfigResource(ConfigResource.Type.TOPIC, TEST_TOPIC), topicConfig)).all().get();
    }

    /**
     * delete the given topics
     *
     * @param client
     */
    public static void deleteTopics(AdminClient client) throws ExecutionException, InterruptedException {
        KafkaFuture<Void> futures = client.deleteTopics(Arrays.asList(TEST_TOPIC)).all();
        futures.get();
    }

    /**
     * describe the given topics
     *
     * @param client
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void describeTopics(AdminClient client) throws ExecutionException, InterruptedException {
//        DescribeTopicsResult ret = client.describeTopics(Arrays.asList(TEST_TOPIC.split(",")));
        DescribeTopicsResult ret = client.describeTopics(Arrays.asList(TEST_TOPIC, "__consumer_offsets"));
        Map<String, TopicDescription> topics = ret.all().get();
        for (Map.Entry<String, TopicDescription> entry : topics.entrySet()) {
            log.info(entry.getKey() + " =============================> " + entry.getValue());
        }
    }

    /**
     * create multiple sample topics
     *
     * @param client
     */
    public static void createTopics(AdminClient client) throws ExecutionException, InterruptedException {
        NewTopic newTopic = new NewTopic(TEST_TOPIC, 3, (short) 1);
        CreateTopicsResult ret = client.createTopics(Arrays.asList(newTopic));
        ret.all().get();
    }

    /**
     * print all topics in the cluster
     *
     * @param client
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void listAllTopics(AdminClient client) throws ExecutionException, InterruptedException {
        ListTopicsOptions options = new ListTopicsOptions();
        options.listInternal(true); // includes internal topics such as __consumer_offsets
        ListTopicsResult topics = client.listTopics(options);
        Set<String> topicNames = topics.names().get();
        log.info("============================================>>>>>>>>>>>> Current topics in this cluster: " + topicNames);
    }

}
