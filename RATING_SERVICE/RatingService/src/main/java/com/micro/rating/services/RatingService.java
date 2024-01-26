package com.micro.rating.services;

import com.micro.rating.entities.Rating;

import java.util.List;

public interface RatingService {

    //create
    Rating create(Rating rating);

    //get all ratings

    List<Rating> getRatings();
    //get all by userid

    List<Rating> getRatingByUserId(String userId);


    //get all by hotel
    List<Rating>getRatingByHotelId(String hotelId);

}
