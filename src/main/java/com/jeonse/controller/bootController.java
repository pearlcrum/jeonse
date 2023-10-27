package com.jeonse.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class bootController {

    @GetMapping("/hello")
    public String hello(){
        log.info("username={}, age={}", "memberName","memberAge");
        log.info("vaild Ok");

        return "/index_1.html";
    }
}
