package com.homeease.registrationservice.controller;

import com.homeease.registrationservice.dto.LoginRequest;
import com.homeease.registrationservice.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/login")
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public boolean userLogin(@RequestBody LoginRequest loginRequest){
        return loginService.validateUser(loginRequest);
    }
}
