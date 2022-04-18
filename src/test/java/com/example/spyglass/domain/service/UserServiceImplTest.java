package com.example.spyglass.domain.service;

import com.example.spyglass.domain.user.exceptions.UserNotFoundException;
import com.example.spyglass.domain.user.models.User;
import com.example.spyglass.domain.user.repos.UserRepo;
import com.example.spyglass.domain.user.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class UserServiceImplTest {

    @MockBean
    private UserRepo mockUserRepo;

    @Autowired
    private UserService userService;
    private User inputUser;
    private User outputUser;
    private User user;


    @BeforeEach
    public void setup() {

        inputUser = new User("Alex", "Brown", "brownboy@gmail.com", "02/19/85", "yellow4");
        outputUser = new User("Alex", "Brown", "brownboy@gmail.com", "02/19/85", "yellow4");
        outputUser.setId(1L);

    }

    @Test
    public void createUser() {
        BDDMockito.doReturn(inputUser).when(mockUserRepo).save(ArgumentMatchers.any());
        User returnedUser = userService.createUser(inputUser);
        Assertions.assertNotNull(returnedUser);
    }

   // @Test
   // public void deleteUser() throws UserNotFoundException {
      //  BDDMockito.doReturn(Optional.of(inputUser)).when(mockUserRepo).delete();
      //  User user1 = userService.deleteUser(user);
      //  Assertions.assertNotNull(user1);

  //  }
    @Test
    public void updateUser() throws UserNotFoundException {
        User expectedUserUpdate = new User("sam","","dul@email.com","09/02/2000","dulpassword");

        BDDMockito.doReturn(Optional.of(user)).when(mockUserRepo).findAllById(1L);
        BDDMockito.doReturn(inputUser).when(mockUserRepo).save(ArgumentMatchers.any());

        User user1 = userService.updateUser(new User());
        Assertions.assertEquals(expectedUserUpdate.toString(),user1.toString());
    }

    @Test
    public void getUserByIdTest() throws UserNotFoundException {
        BDDMockito.doReturn(Optional.empty()).when(mockUserRepo).findAllById(1L);
        User foundUser = userService.findById(1L);

        Assertions.assertEquals(user.toString(),foundUser.toString());
    }
    @Test
    public void updatePassword(){
        BDDMockito.doReturn(Optional.empty()).when(user).setPassword("dulpassword");
        User passwordUser = userService.updatePasswords("dulpassword");

        Assertions.assertEquals(user.toString(),passwordUser.toString());
    }

}