package com.rabbitmqspringscheduler.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    Sender sender;

    public Runner(Sender sender) {
        this.sender = sender;
    }

    @Override
    public void run(String... args) throws Exception {
        sender.send("message");
    }
}
