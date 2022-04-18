package com.example.spyglass.domain.user.services;
import com.example.spyglass.domain.user.exceptions.UserNotFoundException;
import com.example.spyglass.domain.user.models.User;

public interface UserService {

    User createUser(User user);
    User updatePasswords(String password);
    User findById(Long id) throws UserNotFoundException;
    User updateUser(User user) throws UserNotFoundException;
    User findUser (User user) throws UserNotFoundException;
    void deleteUser(User user);
    String createProfile(String firstName, String lastName, String dateOfBirth, String email, String password);

}
