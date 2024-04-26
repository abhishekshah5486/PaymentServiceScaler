package com.abhishek.paymentservicescaler.Dtos;

import com.stripe.model.checkout.Session;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InitiatePaymentRequestDto {
    private Long OrderId;
    private String email;
}
