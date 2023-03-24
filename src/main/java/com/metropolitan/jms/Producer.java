package com.metropolitan.jms;

import com.google.gson.Gson;
import com.metropolitan.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;


import java.util.Map;

@Component
public class Producer {
    @Autowired
    JmsTemplate jmsTemplate;

    public void sendMessage(final String queueName, final Member member) {
        final String textMessage = "Hello " + member.getName();
        System.out.println("Sending message " + textMessage + " to queue - " + queueName);
        jmsTemplate.send(queueName, session -> session.createTextMessage());
    }

}
