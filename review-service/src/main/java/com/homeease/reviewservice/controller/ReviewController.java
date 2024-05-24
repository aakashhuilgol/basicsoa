package com.homeease.reviewservice.controller;

import com.homeease.reviewservice.dto.ReviewRequest;
import com.homeease.reviewservice.dto.ReviewResponse;
import com.homeease.reviewservice.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/review")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createReview(@RequestBody ReviewRequest reviewRequest){
        return reviewService.createReview(reviewRequest);
    }

    @GetMapping("/{profesionalId}")
    public List<ReviewResponse> getReviewsByProductId(@PathVariable String profesionalId) {
        return reviewService.getReviewsByProfesionalId(profesionalId);
    }
}
