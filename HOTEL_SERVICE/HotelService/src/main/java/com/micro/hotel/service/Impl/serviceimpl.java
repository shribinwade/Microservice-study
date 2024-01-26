package com.micro.hotel.service.Impl;

import com.micro.hotel.Repository.repository;
import com.micro.hotel.entities.Hotel;
import com.micro.hotel.exceptions.ResourceNotFoundException;
import com.micro.hotel.service.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class serviceimpl implements service {

    @Autowired
    repository hotelrepository;

    @Override
    public Hotel create(Hotel hotel) {
        String randomId = UUID.randomUUID().toString();
        System.out.println(randomId);
        hotel.setHotelId(randomId);
        return hotelrepository.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelrepository.findAll();
    }

    @Override
    public Hotel get(String id) {
        return hotelrepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Hotel with given id is not found on server !! : "+id));
    }
}
