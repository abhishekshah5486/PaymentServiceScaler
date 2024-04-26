package com.abhishek.paymentservicescaler.Services;

import com.abhishek.paymentservicescaler.PaymentGateway.PaymentGateway;
import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private PaymentGateway paymentGateway;
    public PaymentService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public String initiatePayment(Long id, String email) throws RazorpayException, StripeException {
        return paymentGateway.generatePaymentLink(id, email);
    }
}
