package com.homeease.professionalservice.pros;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;


@Document(value = "professional")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Professional {
    @Id
    private String id;
    private String name;
    private String category;
    private Integer price;
    private Integer contact;

}
