package com.example.spyglass.domain.goals.services;

import com.example.spyglass.domain.goals.enums.GoalType;
import com.example.spyglass.domain.goals.exceptions.GoalNotFoundException;
import com.example.spyglass.domain.goals.models.Goal;
import com.example.spyglass.domain.goals.repos.GoalRepo;
import com.example.spyglass.domain.goals.services.GoalService;
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

import java.util.Date;
import java.util.Optional;

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
    public void setUp(){
        inputGoal = new Goal(5.00,200.00, GoalType.OTHER,new Date());
        outputGoal = new Goal(5.00,200.00, GoalType.OTHER,new Date());
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
        BDDMockito.doReturn(Optional.of(outputGoal)).when(goalRepo).findById(1L);
        Goal foundGoal = goalService.findById(1L);
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
    void updateGoal() throws GoalNotFoundException {
        Goal expectedGoal = new Goal(40.00,500.00,GoalType.TRAVEL,new Date());
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
    void progressBarCal01() {
        BDDMockito.doReturn(outputGoal).when(goalRepo).save(ArgumentMatchers.any());
        Goal returnedGoal = goalService.createGoal(outputGoal);
        Double expected = 2.50;
        Double actual = returnedGoal.getProgressBar();

        Assertions.assertEquals(expected,actual);
    }

    @Test
    void progressBarCal02() {
        Double expected = 12.985;
        Double actual = goalService.progressBarCal(25.97,200.00);

        Assertions.assertEquals(expected,actual);
    }

    @Test
    void progressBarCal03() {
        Double expected = 15.78;
        Double actual = goalService.progressBarCal(31.55,200.00);

        Assertions.assertEquals(expected,actual);
    }


    @Test
    void leftToSave01() {
        Double expected = 195.00;
        Double actual = goalService.leftToSave(200.00,5.00);

        Assertions.assertEquals(expected,actual);
    }

    @Test
    void leftToSave02() {
        Double expected = 144.32;
        Double actual = goalService.leftToSave(200.00,55.68);

        Assertions.assertEquals(expected,actual);
    }

    @Test
    void leftToSave03() {
        outputGoal.setSavedSoFar(24.23);
        BDDMockito.doReturn(outputGoal).when(goalRepo).save(ArgumentMatchers.any());
        Goal returnedGoal = goalService.createGoal(outputGoal);
        Double expected = 175.77;
        Double actual = returnedGoal.getLeftToBeSaved();

        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Completed Goals - Success")
    void completedGoals01(){

        outputGoal.setSavedSoFar(200.00);
        BDDMockito.doReturn(outputGoal).when(goalRepo).save(ArgumentMatchers.any());
        Goal returnedGoal = goalService.createGoal(outputGoal);
        Integer expected = 1;
        Integer actual = returnedGoal.getCompletedGoals().size();

        Assertions.assertEquals(expected,actual);

    }

    @Test
    @DisplayName("Completed Goals - Fail")
    void completedGoals02(){

        outputGoal.setSavedSoFar(195.00);
        BDDMockito.doReturn(outputGoal).when(goalRepo).save(ArgumentMatchers.any());
        Goal returnedGoal = goalService.createGoal(outputGoal);
        Integer expected = 0;
        Integer actual = returnedGoal.getCompletedGoals().size();

        Assertions.assertEquals(expected,actual);

    }

    @Test
    void setGoal() {
    }
}