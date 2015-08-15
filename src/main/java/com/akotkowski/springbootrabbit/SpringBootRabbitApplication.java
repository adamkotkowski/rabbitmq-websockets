package com.akotkowski.springbootrabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootRabbitApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRabbitApplication.class, args);
    }
}
