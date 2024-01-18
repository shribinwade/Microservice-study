package com.micro.user.service.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(){
        super("Resource not found on server");

    }
    //OverLoading
    public ResourceNotFoundException(String message) {
        super(message);
    }
    }
