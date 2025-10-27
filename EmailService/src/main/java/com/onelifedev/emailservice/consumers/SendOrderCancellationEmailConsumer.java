package com.onelifedev.emailservice.consumers;

import org.springframework.kafka.annotation.KafkaListener;

public class SendOrderCancellationEmailConsumer {

    @KafkaListener(topics = "orderCancelled")
    public void handleOrderCancellationEmail(String message) {

    }
}
