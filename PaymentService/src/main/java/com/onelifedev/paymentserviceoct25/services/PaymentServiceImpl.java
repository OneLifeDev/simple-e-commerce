package com.onelifedev.paymentserviceoct25.services;

import com.onelifedev.paymentserviceoct25.paymentgateways.PaymentGateway;
import com.stripe.exception.StripeException;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    private PaymentGateway paymentGateway;

    public PaymentServiceImpl(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    @Override
    public String generatePaymentLink(Long orderId) throws StripeException {
        //Make a call to OrderService to get the order details for the given orderId.
        //List of products and the price & quantity of each product.
        //iPhone 17 pro max - 1, price
        //Watch 3 ultra - 1, price
        //airpods - 1, price

        // Make a call to Payment Gateway and generate the payment link.
        return paymentGateway.generatePaymentLink();
    }
}
