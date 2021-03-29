package com.sujit.ratingservice.controller;

import com.sujit.ratingservice.domain.Rating;
import com.sujit.ratingservice.service.RatingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RatingController {

    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping("/ratings")
    public List<Rating> getRatings() {
        return ratingService.getRatings();
    }
}
