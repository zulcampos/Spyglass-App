package com.example.spyglass.domain.goals.services;
import com.example.spyglass.domain.goals.exceptions.GoalNotFoundException;
import com.example.spyglass.domain.goals.models.Goal;

public class GoalServiceImpl implements GoalService{

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
    public Double progessBarCal(Double currentAmount, Double endGoal) {
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
