package soa.homeease.bookingservice.booking;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name="t_professional_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfessionalDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal price;
    private String payment;
    private String status;
}
