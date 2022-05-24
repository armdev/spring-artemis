package io.project.app.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderListener {

    @JmsListener(destination = "hotel.mycloud")
    public void receiveOrder(String order) {
        log.info("Received order " + order);
    }

}
