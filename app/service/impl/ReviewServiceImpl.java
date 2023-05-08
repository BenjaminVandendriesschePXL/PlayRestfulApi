package service.impl;

import controllers.ReviewDTO;
import controllers.ReviewRequest;
import service.ReviewService;

import java.util.List;

public class ReviewServiceImpl implements ReviewService {
    @Override
    public List<ReviewRequest> findAllReviews() {
        return null;
    }

    @Override
    public ReviewDTO findReviewById(Long reviewId) {
        return null;
    }

    @Override
    public Long createReview(ReviewRequest reviewRequest) {
        return null;
    }

    @Override
    public ReviewDTO updateReview(Long reviewId, ReviewRequest reviewRequest) {
        return null;
    }

    @Override
    public boolean deleteReview(Long reviewId) {
        return false;
    }
}
