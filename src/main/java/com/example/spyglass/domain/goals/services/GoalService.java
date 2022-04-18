package com.example.spyglass.domain.goals.services;
import com.example.spyglass.domain.goals.exceptions.GoalNotFoundException;
import com.example.spyglass.domain.goals.models.CompletedGoal;
import com.example.spyglass.domain.goals.models.Goal;

import com.example.spyglass.domain.goals.models.Goal;

import java.util.ArrayList;
import java.util.List;

public interface GoalService {
    Goal createGoal(Goal goal);
    Goal findById(Long Id)throws GoalNotFoundException;
    Goal updateGoal(Goal goal);
    void deleteGoal(Long Id)throws GoalNotFoundException;
    String progressBarCal(Double savedSoFar, Double endGoal);
    String leftToSave(Double endGoal, Double savedSoFar);
    Double setGoal(Double endGoal);
    ArrayList<CompletedGoal> completedGoals(Double savedSoFar, Double endGoal);


}
