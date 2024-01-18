package com.micro.hotel.service.Service;

import com.micro.hotel.service.entities.Hotel;

import java.util.List;

public interface service {

    //create
     Hotel create (Hotel hotel);

    //  get all
    List<Hotel> getAll();

    //get single
    Hotel get(String id);


}
