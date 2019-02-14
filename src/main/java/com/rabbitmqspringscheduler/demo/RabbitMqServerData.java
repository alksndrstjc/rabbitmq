package com.rabbitmqspringscheduler.demo;

public class RabbitMqServerData {

    private String host;

    private int port;

    private String username;

    private String password;

    private String exchangeName;

    private String routingKey;

    public RabbitMqServerData() {
    }

    public RabbitMqServerData(String host, int port, String username, String password, String exchangeName, String routingKey) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        this.exchangeName = exchangeName;
        this.routingKey = routingKey;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }
}
