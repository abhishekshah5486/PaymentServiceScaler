package com.abhishek.paymentservicescaler.Controllers;

import com.abhishek.paymentservicescaler.Dtos.InitiatePaymentRequestDto;
import com.abhishek.paymentservicescaler.Services.PaymentService;
import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private PaymentService paymentService;
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    @PostMapping("/")
    public String initiatePayment(@RequestBody InitiatePaymentRequestDto initiatePaymentRequestDto) throws RazorpayException, StripeException {
        return paymentService.initiatePayment(
               initiatePaymentRequestDto.getOrderId(),
               initiatePaymentRequestDto.getEmail()
        );
    }
}
