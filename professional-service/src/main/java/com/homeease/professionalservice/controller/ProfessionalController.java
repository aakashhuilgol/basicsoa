package com.homeease.professionalservice.controller;

import com.homeease.professionalservice.dto.ProfessionalRequest;
import com.homeease.professionalservice.dto.ProfessionalResponse;
import com.homeease.professionalservice.service.ProfessionalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pros")
@RequiredArgsConstructor
public class ProfessionalController {

    private final ProfessionalService professionalService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProfessional(@RequestBody ProfessionalRequest professionalrequest){
            professionalService.createProfessional(professionalrequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProfessionalResponse> getAllProfessionals(){
        return professionalService.getAllProfessionals();
    }
}
