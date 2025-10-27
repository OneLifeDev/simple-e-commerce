package com.onelifedev.paymentserviceoct25.paymentgateways;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.model.Product;
import com.stripe.param.PaymentLinkCreateParams;
import com.stripe.param.PriceCreateParams;
import com.stripe.param.ProductCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class StripePaymentGateway implements PaymentGateway {
    @Value("${stripe.key}")
    private String stripeKey;

    @Override
    public String generatePaymentLink() throws StripeException {

        // Set your secret key. Remember to switch to your live secret key in production.
        // See your keys here: https://dashboard.stripe.com/apikeys
        Stripe.apiKey = stripeKey;

        ProductCreateParams productCreateParams =
                ProductCreateParams.builder().setName("Earphones").build();

        Product product = Product.create(productCreateParams);

        //12.868 => 12.87
        //17.87 => 1787
        //500.67 => 50067

        PriceCreateParams priceCreateParams =
                PriceCreateParams.builder()
                        .setCurrency("inr")
                        .setUnitAmount(50067L) // 500.67
                        .setProduct(product.getId())
                        .build();

        Price price = Price.create(priceCreateParams);

        PaymentLinkCreateParams params =
                PaymentLinkCreateParams.builder()
                        .addLineItem(
                                PaymentLinkCreateParams.LineItem.builder()
                                        .setPrice(price.getId())
                                        .setQuantity(1L)
                                        .build()
                        )
                        .setAfterCompletion(
                                PaymentLinkCreateParams.AfterCompletion.builder()
                                        .setRedirect(
                                                PaymentLinkCreateParams.AfterCompletion.Redirect.builder()
                                                        .setUrl("http://scaler.com")
                                                        .build()
                                        )
                                        .setType(PaymentLinkCreateParams.AfterCompletion.Type.REDIRECT)
                                        .build()
                        )
                        .build();

        PaymentLink paymentLink = PaymentLink.create(params);

        return paymentLink.toString();
    }
}
