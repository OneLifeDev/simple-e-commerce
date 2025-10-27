package com.onelifedev.paymentserviceoct25.paymentgateways;

import org.springframework.stereotype.Service;

@Service
public class PhonePePaymentGateway implements PaymentGateway {
    @Override
    public String generatePaymentLink() {
        return "";
    }
}
