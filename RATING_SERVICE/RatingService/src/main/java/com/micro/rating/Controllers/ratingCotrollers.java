package com.micro.rating.Controllers;

import com.micro.rating.entities.Rating;
import com.micro.rating.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class ratingCotrollers {

    @Autowired
    private RatingService ratingService;


    //create Rating
    @PreAuthorize("hasAuthority('Admin')")
    @PostMapping
    public ResponseEntity<Rating> create(@RequestBody Rating rating){

        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));

    }

    //getAll
    @GetMapping
    public ResponseEntity<List<Rating>> getallRatings(){
       return ResponseEntity.ok(ratingService.getRatings());
    }

    //getAllbyuserId
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getallRatingsByUserId(@PathVariable String userId){
        return ResponseEntity.ok(ratingService.getRatingByUserId(userId));
    }

    //getAllbyhotelId
    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getallRatingsByHotelId(@PathVariable String hotelId){
        return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));
    }




}
