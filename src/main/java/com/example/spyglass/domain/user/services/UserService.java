package com.example.spyglass.domain.user.services;
import com.example.spyglass.domain.user.exceptions.IncorrectPasswordException;
import com.example.spyglass.domain.user.exceptions.UserHasBeenDeleted;
import com.example.spyglass.domain.user.exceptions.UserNotFoundException;
import com.example.spyglass.domain.user.models.User;

public interface UserService {

    User createUser(User user);
    User updatePasswords(String password) throws IncorrectPasswordException;
    User findById(Long id) throws UserNotFoundException;
    User updateUser(User user) throws UserNotFoundException;
    User findUser (User user) throws UserNotFoundException;
    Boolean deleteUser(Long id) throws UserHasBeenDeleted;

    User createProfile(User user);

}
