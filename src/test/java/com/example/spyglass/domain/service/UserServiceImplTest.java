package com.example.spyglass.domain.service;

import com.example.spyglass.domain.user.exceptions.UserHasBeenDeleted;
import com.example.spyglass.domain.user.exceptions.UserNotFoundException;
import com.example.spyglass.domain.user.models.User;
import com.example.spyglass.domain.user.repos.UserRepo;
import com.example.spyglass.domain.user.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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
    public void setup() {

        inputUser = new User("Alex", "Brown", "brownboy@gmail.com", "02/19/85");
        outputUser = new User("Alex", "Brown", "brownboy@gmail.com", "02/19/85");
        outputUser.setId(1L);

    }

    @Test
    public void createUser() {
        BDDMockito.doReturn(inputUser).when(mockUserRepo).save(ArgumentMatchers.any());
        User returnedUser = userService.createUser(inputUser);
        Assertions.assertNotNull(returnedUser);
    }

    @Test
    public void deleteUser() throws UserHasBeenDeleted {
        BDDMockito.doReturn(Optional.of(inputUser)).when(mockUserRepo).findById(1l);
        Boolean deleteUser = userService.deleteUser(1l);
        Assertions.assertTrue(deleteUser);

    }
    @Test
    public void updateUser() throws UserNotFoundException {
        User expectedUserUpdate = new User("Sam","Iam","dul@email.com","04/6/1985");
        expectedUserUpdate.setId(1L);

        BDDMockito.doReturn(Optional.of(outputUser)).when(mockUserRepo).findById(1L);
        BDDMockito.doReturn(expectedUserUpdate).when(mockUserRepo).save(ArgumentMatchers.any());

        User actualUser = userService.updateUser(expectedUserUpdate);
        Assertions.assertEquals(expectedUserUpdate.toString(), actualUser.toString());
    }

    @Test
    public void getUserByIdTest() throws UserNotFoundException {
        BDDMockito.doReturn(Optional.of(outputUser)).when(mockUserRepo).findById(1L);
        User foundUser = userService.findById(1L);

        Assertions.assertEquals(outputUser.toString(),foundUser.toString());


    }
     @Test
    public void createProfile() {


        BDDMockito.doReturn(outputUser).when(mockUserRepo).save(ArgumentMatchers.any());
        User completeUser = userService.createProfile(outputUser);
        Assertions.assertNotNull(completeUser);
        Assertions.assertEquals(completeUser.getId(), 1L);

     }

}