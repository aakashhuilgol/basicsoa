package com.homeease.professionalservice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfessionalResponse {
    private String id;
    private String name;
    private String category;
    private Integer price;
    private Integer contact;
}
