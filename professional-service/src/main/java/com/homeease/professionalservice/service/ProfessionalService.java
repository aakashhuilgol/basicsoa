package com.homeease.professionalservice.service;


import com.homeease.professionalservice.dto.ProfessionalRequest;
import com.homeease.professionalservice.dto.ProfessionalResponse;
import com.homeease.professionalservice.pros.Professional;
import com.homeease.professionalservice.repository.ProfessionalRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProfessionalService {

    private final ProfessionalRepository professionalRepository;

    public void createProfessional(ProfessionalRequest professionalRequest){
        Professional professional = Professional.builder()
                .name(professionalRequest.getName())
                .category(professionalRequest.getCategory())
                .price(professionalRequest.getPrice())
                .contact(professionalRequest.getContact())
                .build();

        professionalRepository.save(professional);
        log.info("Professional {} is saved", professional.getId());
    }

    public List<ProfessionalResponse> getAllProfessionals() {
        List<Professional> professionals = professionalRepository.findAll();

        return professionals.stream().map(this::mapToProfessionalResponse).toList();
    }

    private ProfessionalResponse mapToProfessionalResponse(Professional professional) {
        return ProfessionalResponse.builder()
                .id(professional.getId())
                .name(professional.getName())
                .category(professional.getCategory())
                .price(professional.getPrice())
                .contact(professional.getContact())
                .build();
    }
}
