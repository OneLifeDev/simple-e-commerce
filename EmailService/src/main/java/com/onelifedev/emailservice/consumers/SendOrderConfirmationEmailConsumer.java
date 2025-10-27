package com.onelifedev.emailservice.consumers;

import org.springframework.kafka.annotation.KafkaListener;

public class SendOrderConfirmationEmailConsumer {

    @KafkaListener(topics = "orderConfirmed")
    public void handleOrderConfirmationEmail(String message) {

    }
}
