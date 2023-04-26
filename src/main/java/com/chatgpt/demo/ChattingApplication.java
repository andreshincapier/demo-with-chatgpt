package com.chatgpt.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class ChattingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChattingApplication.class, args);
        Mono.just("Hola").subscribe(System.out::println);
    }

}
