package com.example.spyglass.domain.models;

import com.example.spyglass.domain.user.models.User;
import org.junit.jupiter.api.BeforeEach;

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



}
