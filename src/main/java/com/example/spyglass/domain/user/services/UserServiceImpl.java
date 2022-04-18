package com.example.spyglass.domain.user.services;

import com.example.spyglass.domain.user.exceptions.IncorrectPasswordException;
import com.example.spyglass.domain.user.exceptions.UserHasBeenDeleted;
import com.example.spyglass.domain.user.exceptions.UserNotFoundException;
import com.example.spyglass.domain.user.models.User;
import com.example.spyglass.domain.user.repos.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;



@Service
public class UserServiceImpl implements UserService {
    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo){this.userRepo = userRepo;
    }

    @Override
    public User createUser(User user) {
        return userRepo.save(user);
    }



    @Override
    public User updatePasswords(String password) throws IncorrectPasswordException {
        return null;
    }

    @Override
   public User findById(Long id) throws UserNotFoundException {
        logger.debug("Looking for User with id {}", id);
    Optional<User> userOptional = userRepo.findById(id);
      if(userOptional.isEmpty())
          throw new UserNotFoundException("No user with id");
       return userOptional.get();

   }

    @Override
    public User updateUser(User user) throws UserNotFoundException {
        Long id = user.getId();
        Optional<User> userOptional = userRepo.findById(id);
        if(userOptional.isEmpty())
            throw new UserNotFoundException("No user with id");
        return userRepo.save(user);
    }

    @Override
    public User findUser(User user) throws UserNotFoundException {
        Optional<User> userOptional = userRepo.findById(1l);
        if(userOptional.isEmpty())
            throw new UserNotFoundException("User with id not found ");
            return userOptional.get();

    }


    @Override
    public Boolean deleteUser(Long id) throws UserHasBeenDeleted {
        Optional<User> optionalUser = userRepo.findById(id);
        if (optionalUser.isEmpty())
            throw new UserHasBeenDeleted("User " + id + " has been deleted");
            User user = optionalUser.get();
            userRepo.delete(user);
        return true;
    }
    @Override
    public User createProfile(User user) {
        User completeProfile = userRepo.save(user);
        logger.debug("This user is authorized. ");
        return completeProfile;


    }

//    @Override // is deleting user deleting the whole user account?
    //will we need a new exception
//   public void deleteUser(String id){userRepo.delete();}
}
//logger.debug("Looking for User with id {}", id);