package com.micro.hotel.Controllers;

import com.micro.hotel.service.service;
import com.micro.hotel.entities.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {


    @Autowired
    service hotelService;
    //create

    @PreAuthorize("hasAuthority('Admin')")
    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){

        Hotel hotel1 = hotelService.create(hotel);

        return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);

    }

    @PreAuthorize("hasAuthority('SCOPE_internal')")
    @GetMapping(path="/{hotelId}")
    public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId){
        Hotel hotel1 = hotelService.get(hotelId);
        return ResponseEntity.status(HttpStatus.OK).body(hotel1);
    }

    @PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin')")
    @GetMapping
    public ResponseEntity<List<Hotel>> getAll(){
        List<Hotel> all = hotelService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(all);
    }


}
