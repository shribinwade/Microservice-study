package com.micro.user.service.service;

import com.micro.user.service.entities.User;

import java.util.List;

public interface UserService {

    public User saveUser(User user);

    List<User> getAllUser();

    User getUser(String userId);


}
