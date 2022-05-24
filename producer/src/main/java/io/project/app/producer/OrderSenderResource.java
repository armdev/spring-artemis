/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.project.app.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author armena
 */
@RestController
@Slf4j
public class OrderSenderResource {
    
    @Autowired
    private JmsOrderMessagingService jmsOrderMessagingService;
    
    @GetMapping("/send")
    public String send(){
        long currentTimeMillis = System.currentTimeMillis();
        String order = "ORDER-" +currentTimeMillis;
        log.info("SENDING " + order);
        jmsOrderMessagingService.sendOrder(order);        
        return order;
        
    }
    
}
