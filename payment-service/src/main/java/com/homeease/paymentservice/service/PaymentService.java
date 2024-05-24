package com.homeease.paymentservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.homeease.paymentservice.dto.PaymentRequest;
import com.homeease.paymentservice.model.Payment;
import com.homeease.paymentservice.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public String updatePayment(PaymentRequest paymentRequest){
        Payment payment = Payment.builder()
                .bookingId(paymentRequest.getBookingId())
                .paidStatus(paymentRequest.getPaidStatus())
                .build();
        paymentRepository.save(payment);
        String jsonMessage = convertToJSON(payment);
        kafkaTemplate.send("notificationTopic", jsonMessage);
        log.info("Is paid for {}", jsonMessage);
        return jsonMessage;
    }

    private String convertToJSON (Payment payment) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonResponse;
        try {
            jsonResponse = mapper.writeValueAsString(payment);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            jsonResponse = "{\"error\":\"Could not process JSON\"}";
        }
        return jsonResponse;
    }
}
