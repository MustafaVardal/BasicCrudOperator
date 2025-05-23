package com.mustafavardal.user.service;

import com.mustafavardal.user.entity.User;
import com.mustafavardal.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements  UserService{

    private final UserRepository userRepository;


    @Override
    public void addUser(User user) {
        userRepository.save(user);

    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByName(String name) {
        Optional<User> user = userRepository.findByName(name);
        return user.orElseThrow();
    }

    @Override
    public void deleteUserByName(String name) {
        userRepository.deleteByName(name);
    }
}
