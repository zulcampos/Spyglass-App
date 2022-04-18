package com.example.spyglass.domain.goals.models;

import java.util.ArrayList;

public class CompletedGoal {

    private ArrayList<Goal> completedGoals;

    public CompletedGoal() {

    }

    public ArrayList<Goal> getCompletedGoals() {
        return completedGoals;
    }

    public void setCompletedGoals(ArrayList<Goal> completedGoals) {
        this.completedGoals = completedGoals;


    }
}
