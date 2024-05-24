package com.homeease.registrationservice.service;

import com.homeease.registrationservice.dto.LoginRequest;
import com.homeease.registrationservice.model.User;
import com.homeease.registrationservice.repository.RegistrationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginService {
    private final RegistrationRepository registrationRepository;

    public boolean validateUser(LoginRequest loginRequest) {
        User user = registrationRepository.findByUsername(loginRequest.getUsername());
        if (user != null) {
            return loginRequest.getPassword().equals(user.getPassword());
        }
        return false;
    }
}
