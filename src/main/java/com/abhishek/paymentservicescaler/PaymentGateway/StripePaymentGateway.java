package com.abhishek.paymentservicescaler.PaymentGateway;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentLink;
import com.stripe.param.PaymentLinkCreateParams;
import com.stripe.param.PaymentLinkUpdateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import com.stripe.model.Price;
import com.stripe.param.PriceCreateParams;

@Component
@Primary
public class StripePaymentGateway implements PaymentGateway {

    @Override
    public String generatePaymentLink(Long orderId, String email) throws StripeException {
        Stripe.apiKey = "sk_test_51P9qcuSH76pfVgb6U0wWxmfKmLmtNcVcnjYXyttB9C7WS1kii5U89Fb2dAIHH3BMOUtNXKSOcyp6AzkEHR0EOuxK00w4D3VfG4";

        PriceCreateParams priceParams =
                PriceCreateParams.builder()
                        .setUnitAmount(20000L)  // Set the amount in the smallest currency unit (e.g., cents)
                        .setCurrency("inr")
                        .setProduct("prod_PzsRZKDDlzYmOH")  // Replace with your product ID
                        .build();

        Price price = Price.create(priceParams);
        PaymentLinkCreateParams params =
                PaymentLinkCreateParams.builder()
                        .addLineItem(
                                PaymentLinkCreateParams.LineItem.builder()
                                        .setPrice("price_1P9sghSH76pfVgb6OjI6bfjW")
                                        .setQuantity(1L)
                                        .build()
                        )
                        .build();
        PaymentLink paymentLink = PaymentLink.create(params);
        PaymentLink resource = PaymentLink.retrieve(paymentLink.toString());

        PaymentLinkUpdateParams updateParams =
                PaymentLinkUpdateParams.builder()
                        .putMetadata("40507972250738744", "6735")
                        .build();


        PaymentLink updatedPaymentLink = resource.update(updateParams);
        return updatedPaymentLink.toString();
    }
}
