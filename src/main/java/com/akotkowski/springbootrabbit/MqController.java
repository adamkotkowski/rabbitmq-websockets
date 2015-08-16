package com.akotkowski.springbootrabbit;

import com.akotkowski.springbootrabbit.messages.ContentMessage;
import com.akotkowski.springbootrabbit.messages.HelloMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
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

    @Autowired
    SimpMessageSendingOperations messagingTemplate;

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String sayHello(@RequestParam("name") String name){
        rabbitTemplate.convertAndSend(queueName, name);
        return "Message sent to RabbitMQ: Hello from "+name;

    }

    @MessageMapping("/greetings")
    @SendTo("/topic/greetings")
    public ContentMessage greeting(HelloMessage message) throws Exception {
        return produceMessage(message.getName());
    }

    @RabbitListener(queues = "${rabbitmq.queueName}")
    public void receiveMessage(String message) {
        messagingTemplate.convertAndSend("/topic/greetings", produceMessage(message));
    }

    private ContentMessage produceMessage(String message){
        return new ContentMessage("Hello, "+message);
    }
}
