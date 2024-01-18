package com.micro.hotel.service.Controllers;

import com.micro.hotel.service.Service.service;
import com.micro.hotel.service.entities.Hotel;
import lombok.Getter;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {


    @Autowired
    service hotelService;
    //create
    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){

        Hotel hotel1 = hotelService.create(hotel);

        return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);

    }

    @GetMapping(path="/{hotelId}")
    public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId){
        Hotel hotel1 = hotelService.get(hotelId);
        return ResponseEntity.status(HttpStatus.OK).body(hotel1);
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAll(){
        List<Hotel> all = hotelService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(all);
    }


}
