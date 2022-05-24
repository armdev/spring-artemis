package io.project.app.producer;

import javax.jms.JMSException;
import javax.jms.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class JmsOrderMessagingService {

    @Autowired
    private JmsTemplate jms;

    public void sendOrder(String order) {
        jms.convertAndSend("hotel.mycloud", order,
                this::addOrderSource);
    }

    private Message addOrderSource(Message message) throws JMSException {
        message.setStringProperty("X_ROOM_ORDER", "WEB");
        return message;
    }

}
