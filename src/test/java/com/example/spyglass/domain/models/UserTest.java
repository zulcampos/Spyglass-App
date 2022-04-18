package com.example.spyglass.domain.models;

import com.example.spyglass.domain.user.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;

import java.util.ArrayList;
import java.util.List;

public class UserTest {
    private User user1;
    private User user2;

    private User emptyUser1;
    private User emptyUser2;

    @BeforeEach
    public void setUp(){
        emptyUser1 = new User();
        emptyUser2 = new User();

        emptyUser2.setId(1L);

        user2.setId(1L);

    }
//    @Test
//    @DisplayName("User Service: Create User - Success")
//    public void createUserTestSuccess(){
//        BDDMockito.doReturn(repo).when(repo).save(ArgumentMatchers.any());
//        User returnedUser = userService;
//    }


}
