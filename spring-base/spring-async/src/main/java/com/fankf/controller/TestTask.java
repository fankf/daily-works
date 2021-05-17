package com.fankf.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@EnableScheduling
public class TestTask {
    @Scheduled(fixedRate = 1000)
    public void task(){
      log.info("11111111111");
    }
}
