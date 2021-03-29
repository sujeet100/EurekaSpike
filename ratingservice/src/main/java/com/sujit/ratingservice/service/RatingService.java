package com.sujit.ratingservice.service;

import com.sujit.ratingservice.domain.Rating;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {
    public List<Rating> getRatings() {
        return List.of(
                new Rating("Batman", 9),
                new Rating("Joker", 10)
        );
    }
}
