package com.example.spyglass.domain.user.services;
import com.example.spyglass.domain.user.models.User;

public interface UserService {

    void createProfile(User user);
    User updatePasswords(String password);
    User findById(Long Id);
    User createUser(User user);
    User updateUser(User user);
    User findUser (User user);
    User deleteUser(User user);

}
