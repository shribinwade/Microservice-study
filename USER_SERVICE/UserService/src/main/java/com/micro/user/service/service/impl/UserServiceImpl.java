package com.micro.user.service.service.impl;

import com.micro.user.service.entities.Hotel;
import com.micro.user.service.entities.Rating;
import com.micro.user.service.entities.User;
import com.micro.user.service.exceptions.ResourceNotFoundException;
import com.micro.user.service.repositories.UserRepository;
import com.micro.user.service.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;


//    @Autowired
//    Logger logger;

    @Override
    public User saveUser(User user) {

        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);

        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {


        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on server !! : " + userId));

        //Fetching Ratings from above user from the Rating Services

        Rating[] forObject = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(), Rating[].class);

        log.info(" {} ",forObject);

        //converting array to arrayList
        List<Rating> ratings = Arrays.stream(forObject).toList();

        //=======================================================================
        List<Rating> ratingList = ratings.stream().map(rating ->{

            //api call to hotel service to get the hotel

            //http://localhost:8082/hotel/e5459d35-5dc1-4ba5-b294-0154d04cf27a

            ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotel/"+rating.getHotelId(), Hotel.class);

            Hotel hotel = forEntity.getBody();

            log.info("Response status code: {} ",hotel);

            //set the hotel to rating
            rating.setHotel(hotel);

            //return the rating
            return rating;
        }).collect(Collectors.toList());
       //=================================================================================
        user.setRatings(ratingList);

        return user;

    }
}
