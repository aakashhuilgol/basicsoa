package com.homeease.registrationservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.homeease.registrationservice.dto.RegistrationRequest;
import com.homeease.registrationservice.dto.RegistrationResponse;
import com.homeease.registrationservice.model.User;
import com.homeease.registrationservice.repository.RegistrationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class RegistrationService {
    private final RegistrationRepository registrationRepository;

    public String createUser(RegistrationRequest registrationRequest){
        User user = User.builder()
                .username(registrationRequest.getUsername())
                .password(registrationRequest.getPassword())
                .name(registrationRequest.getName())
                .address(registrationRequest.getAddress())
                .contact(registrationRequest.getContact())
                .build();
        registrationRepository.save(user);
        return convertToJSON(user);
    }

    private String convertToJSON (User user) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonResponse;
        try {
            jsonResponse = mapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            jsonResponse = "{\"error\":\"Could not process JSON\"}";
        }
        return jsonResponse;
    }

    public List<RegistrationResponse> getAllUser() {
        List<User> users = registrationRepository.findAll();

        return users.stream().map(this::mapToRegistrationResponse).toList();

    }

    private RegistrationResponse mapToRegistrationResponse(User user) {
        return RegistrationResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .name(user.getName())
                .address(user.getAddress())
                .contact(user.getContact())
                .build();
    }

    public User getUserById(String id) {
        Optional<User> user = registrationRepository.findById(id);
        return user.orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }
}
