package com.example.spyglass.domain.service;

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

    @BeforeEach
    public void setup(){

        inputUser = new User("Alex", "Brown", "brownboy@gmail.com", "02/19/85", "yellow4");
        outputUser = new User("Alex", "Brown", "brownboy@gmail.com", "02/19/85", "yellow4");
        outputUser.setId(1L);

    }

    @Test
    public void createUser(){
        BDDMockito.doReturn(inputUser).when(mockUserRepo).save(ArgumentMatchers.any());
        User returnedUser = userService.createUser(inputUser);
        Assertions.assertNotNull(returnedUser);
    }
   // @Test
    //public void deleteUserTest(){
    //    BDDMockito.doReturn(inputUser).when(mockUserRepo).save(ArgumentMatchers.any());
     //   Assertions.a
    }




//}
