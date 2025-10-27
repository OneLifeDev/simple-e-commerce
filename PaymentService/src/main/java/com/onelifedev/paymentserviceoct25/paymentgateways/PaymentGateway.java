package com.onelifedev.paymentserviceoct25.paymentgateways;

import com.stripe.exception.StripeException;

public interface PaymentGateway {
    String generatePaymentLink() throws StripeException;
}
