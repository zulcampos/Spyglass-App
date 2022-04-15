package com.example.spyglass.domain.goals.services;
import com.example.spyglass.domain.goals.exceptions.GoalNotFoundException;
import com.example.spyglass.domain.goals.models.Goal;

import com.example.spyglass.domain.goals.models.Goal;

public interface GoalService {
    Goal createGoal(Goal goal);
    Goal findById(Long Id);
    Goal updateGoal(Goal goal);
    void deleteGoal(Long Id)throws GoalNotFoundException;
    Double progessBarCal(Double currentAmount, Double endGoal);
    Double leftToSave(Double endGoal, Double currentAmount);
    Double setGoal(Double endGoal);

}
