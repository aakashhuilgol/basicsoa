package com.homeease.registrationservice.controller;

import com.homeease.registrationservice.dto.RegistrationRequest;
import com.homeease.registrationservice.dto.RegistrationResponse;
import com.homeease.registrationservice.model.User;
import com.homeease.registrationservice.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class RegistrationController {
    private final RegistrationService registrationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createUser(@RequestBody RegistrationRequest registrationRequest){
        return registrationService.createUser(registrationRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<RegistrationResponse> getAllUser(){

        return registrationService.getAllUser();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable String id) {
        try {
            User user = registrationService.getUserById(id);
            return ResponseEntity.ok(user);
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
