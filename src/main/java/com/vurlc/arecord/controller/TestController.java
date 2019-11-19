package com.vurlc.arecord.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/test")
public class TestController {


    @MessageMapping({"/echo"})
    @SendTo("/user")
    public Mono<String> echo(){
        return Mono.just("ECHO >>"+ "hello");
    }
}

//    @MessageMapping("/test1")
//    public String rese(){
//
//    }
