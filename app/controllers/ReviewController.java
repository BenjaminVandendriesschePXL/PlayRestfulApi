package controllers;


import service.ReviewService;

public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    public ReviewDTO getReviewById(Long id){
        return reviewService.findReviewById(id);
    }
}
