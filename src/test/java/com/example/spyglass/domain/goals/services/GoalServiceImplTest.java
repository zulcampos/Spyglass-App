package com.example.spyglass.domain.goals.services;

import com.example.spyglass.domain.goals.enums.GoalType;
import com.example.spyglass.domain.goals.exceptions.GoalNotFoundException;
import com.example.spyglass.domain.goals.models.Goal;
import com.example.spyglass.domain.goals.repos.GoalRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

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

    @BeforeEach
    public void setUp() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
        Date endGoalDate = format.parse("05-06-2022");
        inputGoal = new Goal(5.00,200.00, GoalType.OTHER,new Date(),endGoalDate);
        outputGoal = new Goal(5.00,200.00, GoalType.OTHER,new Date(),endGoalDate);
        outputGoal.setId(1l);
    }

    @Test
    @DisplayName("Goal service create - success")
    void createGoal() {
        BDDMockito.doReturn(outputGoal).when(goalRepo).save(ArgumentMatchers.any());
        Goal returnedGoal = goalService.createGoal(inputGoal);
        Assertions.assertNotNull(returnedGoal);
    }

    @Test
    @DisplayName("Find Goal by Id")
    void findById01() throws GoalNotFoundException {
        BDDMockito.doReturn(Optional.of(outputGoal)).when(goalRepo).findById(1l);
        Goal foundGoal = goalService.findById(1l);
        Assertions.assertEquals(outputGoal.toString(),foundGoal.toString());
    }

    @Test
    @DisplayName("Failed find by id")
    public void findById02(){
        BDDMockito.doReturn(Optional.empty()).when(goalRepo).findById(1l);
        Assertions.assertThrows(GoalNotFoundException.class,() -> {
            goalService.findById(1l);
        });
    }


    @Test
    @DisplayName("Goal service update goal success")
    void updateGoal() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
        Date endGoalDate = format.parse("05-06-2022");
        Goal expectedGoal = new Goal(40.00,500.00,GoalType.TRAVEL,new Date(),endGoalDate);
        expectedGoal.setId(1l);

        BDDMockito.doReturn(Optional.of(outputGoal)).when(goalRepo).findById(1l);
        BDDMockito.doReturn(expectedGoal).when(goalRepo).save(ArgumentMatchers.any());

        Goal actualGoal = goalService.updateGoal(expectedGoal);
        Assertions.assertEquals(expectedGoal.toString(),actualGoal.toString());

    }

    @Test
    void deleteGoal() {
        Assertions.assertThrows(GoalNotFoundException.class, () -> {
            BDDMockito.doReturn(goalService.findById(1l));
        });
    }

    @Test
    void progressBarCal() {
        String expected = "2.5%";
        Double actual = goalService.progressBarCal(5.00,200.00);

        Assertions.assertEquals(expected,actual);
    }

    @Test
    void leftToSave() {
        String expected = "$195";
        Double actual = goalService.leftToSave(200.00,5.00);

        Assertions.assertEquals(expected,actual);
    }

    @Test
    void setGoal() {
    }
}