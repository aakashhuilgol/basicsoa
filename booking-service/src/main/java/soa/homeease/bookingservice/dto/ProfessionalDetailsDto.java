package soa.homeease.bookingservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfessionalDetailsDto {
    private Long id;
    private String name;
    private BigDecimal price;
    private String payment;
    private String status;
}
