package com.sujit.movieservice.service;

import com.sujit.movieservice.domain.Movie;
import com.sujit.movieservice.domain.Rating;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MovieService {
    private final RestTemplate restTemplate;

    public MovieService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Movie> getMovies() {
        List<Rating> ratings = Arrays.asList(restTemplate.getForEntity("http://ratingservice/ratings", Rating[].class)
                                                         .getBody());

        Map<String, Integer> ratingsMap = ratings.stream()
                                                 .collect(Collectors.toMap(Rating::getName, Rating::getRating));
        return List.of(
                new Movie("Batman", "Action", ratingsMap.get("Batman")),
                new Movie("Joker", "Action", ratingsMap.get("Joker"))
        );
    }
}
