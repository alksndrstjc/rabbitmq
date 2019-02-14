package com.rabbitmqspringscheduler.demo;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class RabbitTemplateFactoryConfig {

    ApplicationArguments arguments;

    @Autowired
    public RabbitTemplateFactoryConfig(ApplicationArguments arguments) {
        this.arguments = arguments;
    }

    @Bean
    RabbitTemplateFactory rabbitTemplateFactory() {
        String[] args = arguments.getSourceArgs();
        return new RabbitTemplateFactory(new RabbitMqServerData(args[0], Integer.valueOf(args[1]), args[2], args[3], args[4], args[5]));
    }

    @Bean
    @Scope(scopeName = "prototype")
    RabbitTemplate customRabbitTemplate(RabbitTemplateFactory factory) throws Exception {
        return factory.getObject();
    }
}
