package com.example.usertwo.listeners;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class UserListener {
    private final JmsTemplate jmsTemplate;

    public UserListener(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @JmsListener(destination = "msg_for_second_service",
            containerFactory = "default_container_factory")
    public void newUserArrivedFirst(Message<String> message) {
        System.out.println("Second service msg -> "+message.getPayload());
    }
}
