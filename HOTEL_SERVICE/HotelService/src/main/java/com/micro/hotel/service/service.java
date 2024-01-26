package com.micro.hotel.service;

import com.micro.hotel.entities.Hotel;

import java.util.List;

public interface service {

    //create
     Hotel create (Hotel hotel);

    //  get all
    List<Hotel> getAll();

    //get single
    Hotel get(String id);


}
