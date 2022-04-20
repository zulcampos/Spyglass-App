package com.example.spyglass.domain.users.controller;

import com.example.spyglass.BaseControllerTest;
import com.example.spyglass.domain.user.exceptions.UserNotFoundException;
import com.example.spyglass.domain.user.models.User;
import com.example.spyglass.domain.user.services.UserService;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)

public class UserControllerTest extends BaseControllerTest {

    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    private User mockUser1;
    private User mockUser2;

    @BeforeEach
    public void setUp() {

        mockUser1 = new User("Ab", "Soul", "ab-soul@music.com", "02/04/1978");
        mockUser1.setId(1L);
        mockUser2 = new User("Mac", "Miller", "macmiller@music.com", "04/23/1994");
        mockUser2.setId(2L);
    }

    @Test
    @DisplayName("Goal Post: /users - success")
    public void createUserSuccess() throws Exception {
        BDDMockito.doReturn(mockUser1).when(userService).createUser(ArgumentMatchers.any());

        mockMvc.perform(MockMvcRequestBuilders.post("/goals")
                        .contentType(MediaType.APPLICATION_JSON)
                        .contentType(asJsonString(mockUser1)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName", Is.is("Ab")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName", Is.is("Soul")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email", Is.is("ab-soul@music.com")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.dateOfBirth", Is.is("02/04/1979")));
    }

    @Test
    @DisplayName("GET /users/1 - Found")
    public void getUserByIdTestSuccess() throws Exception {
        BDDMockito.doReturn(mockUser1).when(userService).findById(1L);

        mockMvc.perform(get("/users/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName", Is.is("Ab")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName", Is.is("Soul")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email", Is.is("ab-soul@music.com")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.dateOfBirth", Is.is("02/04/1979")));


    }

    @Test
    @DisplayName("GET /users/1 - Not Found")
    public void getUserByIdTestFail() throws Exception {
        BDDMockito.doThrow(new UserNotFoundException("Not Found")).when(userService).findById(1L);
        mockMvc.perform(get("/users/{id}", 1))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Put /users/1 - Success")
    public void putUserTest() throws Exception {
        User user = new User("Ab", "Soul", "ab-soul@music.com", "02-04-79");
        user.setId(1L);
        BDDMockito.doReturn(user).when(userService).updateUser(any());
        mockMvc.perform(put("/users/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(mockUser1)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName", Is.is("Ab")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName", Is.is("Soul")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email", Is.is("ab-soul@music.com")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.dateOfBirth", Is.is("02/04/1979")));

    }

    @Test
    @DisplayName("PUT /users/1 - Not Found")
    public void putGoalTestNotFound() throws Exception {
        BDDMockito.doThrow(new UserNotFoundException("Not Found")).when(userService).updateUser(any());
        mockMvc.perform(put("/users/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(mockUser1)))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("DELETE /users/1 - Success")
    public void deleteUserTestNotSuccess() throws Exception {
        BDDMockito.doReturn(true).when(userService).deleteUser(any());
        mockMvc.perform(delete("/users/{id}", 1))
                .andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("DELETE /users/1 - Not Found")
    public void deleteGoalTestNotFound() throws Exception {
        BDDMockito.doThrow(new UserNotFoundException("Not Found")).when(userService).deleteUser(any());
        mockMvc.perform(delete("/users/{id}", 1))
                .andExpect(status().isNotFound());
    }
}