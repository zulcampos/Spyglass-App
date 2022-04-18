package com.example.spyglass.domain.goals.controllers;

import com.example.spyglass.domain.BaseControllerTest;
import com.example.spyglass.domain.goals.enums.GoalType;
import com.example.spyglass.domain.goals.exceptions.GoalNotFoundException;
import com.example.spyglass.domain.goals.models.Goal;
import com.example.spyglass.domain.goals.services.GoalService;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import javax.persistence.EnumType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class GoalControllerTest extends BaseControllerTest {

    @MockBean
    private GoalService goalService;

    @Autowired
    private MockMvc mockMvc;

    private Goal mockGoal1;
    private Goal mockGoal2;

    @BeforeEach
    public void setUp(){

        mockGoal1 = new Goal(5.00,200.00, GoalType.TRAVEL,new Date());
        mockGoal1.setId(1L);
        mockGoal2 = new Goal(5.00,100.00,GoalType.HOME, new Date());
        mockGoal2.setId(2L);
    }

    @Test
    @DisplayName("Goal Post: /goals - success")
    public void createGoalSuccess()throws Exception{
        BDDMockito.doReturn(mockGoal1).when(goalService).createGoal(any());

        mockMvc.perform(MockMvcRequestBuilders.post("/goals")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(mockGoal1)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1L)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.savedSoFar", Is.is(5.00)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.endGoal", Is.is(200.00)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.goalType", Is.is(GoalType.TRAVEL)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.goalStartDate", Is.is(new Date())));

    }
    @Test
    @DisplayName("GET /goals/1 - Found")
    public void getGoalByIdTestSuccess() throws Exception{
        BDDMockito.doReturn(mockGoal1).when(goalService).findById(1L);

        mockMvc.perform(get("/goals/{id}",1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", Is.is(1L)))
                .andExpect(jsonPath("$.savedSoFar", Is.is(5.00)))
                .andExpect(jsonPath("$.endGoal", Is.is(200.00)))
                .andExpect(jsonPath("$.goalType", Is.is(GoalType.TRAVEL)))
                .andExpect(jsonPath("$.goalStartDate", Is.is(new Date())));
    }
    @Test
    @DisplayName("GET /goals/1 - Not Found")
    public void getGoalByIdTestFail() throws Exception{
        BDDMockito.doThrow(new GoalNotFoundException("Not Found")).when(goalService).findById(1L);
        mockMvc.perform(get("/goals/{id}", 1))
                .andExpect(status().isNotFound());
    }
    @Test
    @DisplayName("Put /goal/1 - Success")
    public void putGoalTest () throws Exception{
        Goal goal = new Goal(10.00,500.00, GoalType.EMERGENCY,new Date());
        goal.setId(1L);
        BDDMockito.doReturn(goal).when(goalService).updateGoal(any());
        mockMvc.perform(put("/goals/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(mockGoal1)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(1L)))
                .andExpect(jsonPath("$.savedSoFar", is(10.00)))
                .andExpect(jsonPath("$.endGoal", is(500.00)))
                .andExpect(jsonPath("$.goalType", is(GoalType.EMERGENCY)))
                .andExpect(jsonPath("$.goalStartDate", is(new Date())));
    }

    @Test
    @DisplayName("PUT /goals/1 - Not Found")
    public void putGoalTestNotFound() throws Exception{
        BDDMockito.doThrow(new GoalNotFoundException("Not Found")).when(goalService).updateGoal( any());
        mockMvc.perform(put("/goals/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(mockGoal1)))
                .andExpect(status().isNotFound());
    }
    @Test
    @DisplayName("DELETE /goals/1 - Success")
    public void deleteGoalTestNotSuccess() throws Exception{
        BDDMockito.doReturn(true).when(goalService).deleteGoal(any());
        mockMvc.perform(delete("/goals/{id}", 1))
                .andExpect(status().isNoContent());
    }
    @Test
    @DisplayName("DELETE /goals/1 - Not Found")
    public void deleteGoalTestNotFound() throws Exception{
        BDDMockito.doThrow(new GoalNotFoundException("Not Found")).when(goalService).deleteGoal(any());
        mockMvc.perform(delete("/goals/{id}", 1))
                .andExpect(status().isNotFound());
    }

    }

