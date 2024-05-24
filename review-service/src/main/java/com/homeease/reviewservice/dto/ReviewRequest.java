package com.homeease.reviewservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewRequest {
    private String bookingid;
    private String profesionalid;
    private String uid;
    private String rating;
    private String comment;
}
