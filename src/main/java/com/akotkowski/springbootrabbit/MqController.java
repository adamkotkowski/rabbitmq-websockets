package com.akotkowski.springbootrabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MqController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.queueName}")
    String queueName;


    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String sayHello(@RequestParam("name") String name){

        rabbitTemplate.convertAndSend(queueName, "Hello from "+name+"!");

        return "Hello "+name;

    }
}
