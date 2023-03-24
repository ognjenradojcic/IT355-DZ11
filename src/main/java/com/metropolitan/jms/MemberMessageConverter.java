package com.metropolitan.jms;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.metropolitan.domain.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

import javax.jms.*;

public class MemberMessageConverter implements MessageConverter {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(MemberMessageConverter.class);

    ObjectMapper mapper;

    public MemberMessageConverter() {
        mapper = new ObjectMapper();
    }

    @Override
    public Message toMessage(Object object, Session session)
            throws JMSException {
        Member member = (Member) object;
        String payload = null;
        try {
            payload = mapper.writeValueAsString(member);
            LOGGER.info("outbound json='{}'", payload);
        } catch (JsonProcessingException e) {
            LOGGER.error("error converting form member", e);
        }

        TextMessage message = session.createTextMessage();
        message.setText(payload);

        return message;
    }

    @Override
    public Object fromMessage(Message message) throws JMSException {
        TextMessage textMessage = (TextMessage) message;
        String payload = textMessage.getText();
        LOGGER.info("inbound json='{}'", payload);

        Member member = null;
        try {
            member = mapper.readValue(payload, Member.class);
        } catch (Exception e) {
            LOGGER.error("error converting to member", e);
        }

        return member;
    }
}
