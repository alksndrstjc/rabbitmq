package com.rabbitmqspringscheduler.demo;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.FactoryBean;

public class RabbitTemplateFactory implements FactoryBean<RabbitTemplate> {

    RabbitMqServerData rabbitMqServerData;

    public RabbitTemplateFactory(RabbitMqServerData rabbitMqServerData) {
        this.rabbitMqServerData = rabbitMqServerData;
    }

    @Override
    public RabbitTemplate getObject() throws Exception {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(cachingConnectionFactory());
        rabbitTemplate.setExchange(rabbitMqServerData.getExchangeName());
        rabbitTemplate.setRoutingKey(rabbitMqServerData.getRoutingKey());
        return rabbitTemplate;
    }

    @Override
    public Class<?> getObjectType() {
        return RabbitTemplate.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    private CachingConnectionFactory cachingConnectionFactory() {
        CachingConnectionFactory factory = new CachingConnectionFactory();
        factory.setHost(rabbitMqServerData.getHost());
        factory.setPort(rabbitMqServerData.getPort());
        factory.setUsername(rabbitMqServerData.getUsername());
        factory.setPassword(rabbitMqServerData.getPassword());

        return factory;
    }
}
