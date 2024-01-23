package com.micro.user.service.external.services;

import com.micro.user.service.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@FeignClient(name = "RATING-SERVICE")
public interface RatingService
{
    //get

    //post

    @PostMapping("/ratings")
    public Rating createRating(Rating values);

    //PUT
    @PutMapping("/ratings/{id}")
    public Rating updateRating(@PathVariable("id") String ratingId, Rating rating);

    @DeleteMapping("/ratings/{id}")
    public Rating deleteRating(@PathVariable("id") String ratingId);
}
