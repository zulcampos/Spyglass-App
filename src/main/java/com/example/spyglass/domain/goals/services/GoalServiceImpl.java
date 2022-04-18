package com.example.spyglass.domain.goals.services;
import com.example.spyglass.domain.goals.exceptions.GoalNotFoundException;
import com.example.spyglass.domain.goals.models.Goal;

import com.example.spyglass.domain.goals.models.Goal;
import com.example.spyglass.domain.goals.repos.GoalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class GoalServiceImpl implements GoalService{

    private GoalService goalService;
    @Autowired
    private GoalRepo goalRepo;

    @Override
    public Goal createGoal(Goal goal) {
    return null;
    }

    @Override
    public Goal findById(Long Id) throws GoalNotFoundException {
        Optional<Goal> goalOptional = goalRepo.findById(Id);
        if(goalOptional.isEmpty())
            throw new GoalNotFoundException("Goal Not Found");
        return goalOptional.get();
    }

    @Override
    public Goal updateGoal(Goal goal) throws GoalNotFoundException {
        Long id = goal.getId();
        Optional<Goal> goalOptional = goalRepo.findById(id);
        if(goalOptional.isEmpty())
            throw new GoalNotFoundException("Goal not Found");
        return goalRepo.save(goal);
    }

    @Override
    public void deleteGoal(Long Id) throws GoalNotFoundException {
        Optional<Goal> goalOptional = goalRepo.findById(Id);
        if(goalOptional.isEmpty())
            throw new GoalNotFoundException("No goal with that Id");
        Goal goalToRemove = goalOptional.get();
        goalRepo.delete(goalToRemove);
    }

    @Override
    public Double progressBarCal(Double savedSoFar, Double endGoal) {
        return null;
    }

    @Override
    public Double leftToSave(Double endGoal, Double savedSoFar) {
        return null;
    }

    @Override
    public Double setGoal(Double endGoal) {
        return null;
    }
}
