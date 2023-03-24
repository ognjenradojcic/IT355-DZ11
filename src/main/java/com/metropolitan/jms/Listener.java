package com.metropolitan.jms;

import com.metropolitan.domain.Member;
import com.metropolitan.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

@Component
public class Listener {
    @Autowired
    private Producer producer;

    @Autowired
    private MemberService memberService;

    @JmsListener(destination = "inbound.queue")
    public void recieveMessage(Member member) throws JMSException {
        memberService.add(member);
        System.out.println(member);
        producer.sendMessage("outbound.queue", member);
    }
}
