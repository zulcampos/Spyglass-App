package com.example.spyglass.domain.goals.services;

public interface GoalService {
    Goal createGoal(Goal goal);
    Goal findById(Long Id);
    Goal updateGoal(Goal goal);
    Goal deleteGoal(Long Id);
    Double progessBarCal(Double currentAmount, Double endGoal);
    Double leftToSave(Double endGoal, Double currentAmount);


}
