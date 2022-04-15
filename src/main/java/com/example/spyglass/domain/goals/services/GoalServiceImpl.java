package com.example.spyglass.domain.goals.services;
import com.example.spyglass.domain.goals.exceptions.GoalNotFoundException;
import com.example.spyglass.domain.goals.models.Goal;

import com.example.spyglass.domain.goals.models.Goal;
import com.example.spyglass.domain.goals.repos.GoalRepo;

public class GoalServiceImpl implements GoalService{

    private GoalService goalService;
    private GoalRepo goalRepo;

    @Override
    public Goal createGoal(Goal goal) {return null;
    }

    @Override
    public Goal findById(Long Id) {return null;
    }

    @Override
    public Goal updateGoal(Goal goal) {return null;
    }

    @Override
    public void deleteGoal(Long Id) throws GoalNotFoundException {
    }

    @Override
    public Double progressBarCal(Double currentAmount, Double endGoal) {
        return null;
    }

    @Override
    public Double leftToSave(Double endGoal, Double currentAmount) {
        return null;
    }

    @Override
    public Double setGoal(Double endGoal) {
        return null;
    }
}
