package com.mustafavardal.user.service;

import com.mustafavardal.user.entity.User;

import java.util.List;

public interface UserService {


    void addUser(User user);

    List<User> getAll();

    User getUserByName(String name);

    void deleteUserByName(String name);
}
