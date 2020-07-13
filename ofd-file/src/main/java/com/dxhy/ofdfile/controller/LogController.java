package com.dxhy.ofdfile.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/log")
public class LogController {

    @GetMapping("/{logs}")
    public void log0(@PathVariable String logs) {
        log.info(logs);
    }

    @PostMapping("/post")
    public void log1(@RequestBody String logs) {
        log.info(logs);
    }
}
