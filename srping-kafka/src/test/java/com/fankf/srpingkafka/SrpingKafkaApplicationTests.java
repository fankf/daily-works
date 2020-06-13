package com.fankf.srpingkafka;

import com.fankf.srpingkafka.controller.KafkaMessageProduct;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SrpingKafkaApplicationTests {

    @Autowired
    private KafkaMessageProduct product;

    @Test
    void contextLoads() {
        product.send("message");
    }

}
