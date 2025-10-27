package com.onelifedev.paymentserviceoct25.controllers;

import com.onelifedev.paymentserviceoct25.services.PaymentService;
import com.stripe.exception.StripeException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/initiate")
    public String initiatePayment(Long orderId) throws StripeException {
        return paymentService.generatePaymentLink(orderId);
    }
}
