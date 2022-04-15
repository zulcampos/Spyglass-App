package com.example.spyglass.domain.goals.services;

import com.example.spyglass.domain.goals.models.Goal;
import com.example.spyglass.domain.goals.repos.GoalRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ExtendWith(SpringExtension.class)
class GoalServiceImplTest {

    @MockBean
    private GoalRepo goalRepo;

    @Autowired
    private GoalService goalService;

    private Goal inputGoal;
    private Goal outputGoal;

    @Test
    void createGoal() {
    }

    @Test
    void findById() {
    }

    @Test
    void updateGoal() {
    }

    @Test
    void deleteGoal() {
    }

    @Test
    void progessBarCal() {
    }

    @Test
    void leftToSave() {
    }

    @Test
    void setGoal() {
    }
}