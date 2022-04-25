package com.example.spyglass.domain.goals.services;
import com.example.spyglass.domain.goals.models.Goal;
import com.example.spyglass.domain.goals.exceptions.GoalNotFoundException;
import com.example.spyglass.domain.goals.models.CompletedGoal;

import java.util.ArrayList;
import java.util.List;

public interface GoalService {
    Goal createGoal(Goal goal);
    Goal findById(Long Id)throws GoalNotFoundException;
    Goal updateGoal(Long Id) throws GoalNotFoundException;
    void deleteGoal(Long Id)throws GoalNotFoundException;
    Double progressBarCal(Double savedSoFar, Double endGoal);
    Double leftToSave(Double endGoal, Double savedSoFar);
    ArrayList<CompletedGoal> completedGoals();
    List<Goal> findAllGoals();


}
