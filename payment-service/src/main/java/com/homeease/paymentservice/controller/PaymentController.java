package com.homeease.paymentservice.controller;

import com.homeease.paymentservice.dto.PaymentRequest;
import com.homeease.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createProfessional(@RequestBody PaymentRequest paymentRequest){
        return paymentService.updatePayment(paymentRequest);
    }
}
