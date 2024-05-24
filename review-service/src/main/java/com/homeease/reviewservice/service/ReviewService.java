package com.homeease.reviewservice.service;

import com.homeease.reviewservice.dto.ReviewRequest;
import com.homeease.reviewservice.dto.ReviewResponse;
import com.homeease.reviewservice.model.Review;
import com.homeease.reviewservice.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public String createReview(ReviewRequest reviewRequest){
        Review review = Review.builder()
                .bookingid(reviewRequest.getBookingid())
                .profesionalid(reviewRequest.getProfesionalid())
                .uid(reviewRequest.getUid())
                .rating(reviewRequest.getRating())
                .comment(reviewRequest.getComment())
                .build();
        reviewRepository.save(review);
        return review.toString();
    }

    public List<ReviewResponse> getReviewsByProfesionalId(String profesionalId) {
        List<Review> reviews = reviewRepository.findByProfesionalid(profesionalId);

        return reviews.stream().map(this::mapToReviewResponse).toList();

    }

    private ReviewResponse mapToReviewResponse(Review review) {
        return ReviewResponse.builder()
                .id(review.getId())
                .profesionalid(review.getProfesionalid())
                .bookingid(review.getBookingid())
                .comment(review.getComment())
                .uid(review.getUid())
                .rating(review.getRating())
                .build();
    }
}
