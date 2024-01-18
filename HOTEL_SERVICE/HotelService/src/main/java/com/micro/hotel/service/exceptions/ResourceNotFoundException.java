package com.micro.hotel.service.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(){
        super("Resource not found on server");

    }
    //OverLoading
    public ResourceNotFoundException(String message) {

        super(message);
    }
    }
