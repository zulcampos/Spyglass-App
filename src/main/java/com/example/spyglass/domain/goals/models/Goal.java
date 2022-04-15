package com.example.spyglass.domain.goals.models;

import java.util.Date;

public class Goal {

    private Double startingAmount;
    private Double currentAmount;
    private Double endGoal;
    private Enum goalType;
    private Date goalStartDate;


    public Goal (){

    }

    public Goal(Double startingAmount, Double endGoal, Enum goalType, Date goalStartDate) {
        this.startingAmount = startingAmount;
        this.endGoal = endGoal;
        this.goalType = goalType;
        this.goalStartDate = goalStartDate;
    }

    public Double getStartingAmount() {
        return startingAmount;
    }

    public void setStartingAmount(Double startingAmount) {
        this.startingAmount = startingAmount;
    }

    public Double getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(Double currentAmount) {
        this.currentAmount = currentAmount;
    }

    public Double getEndGoal() {
        return endGoal;
    }

    public void setEndGoal(Double endGoal) {
        this.endGoal = endGoal;
    }

    public Enum getGoalType() {
        return goalType;
    }

    public void setGoalType(Enum goalType) {
        this.goalType = goalType;
    }

    public Date getGoalStartDate() {
        return goalStartDate;
    }

    public void setGoalStartDate(Date goalStartDate) {
        this.goalStartDate = goalStartDate;
    }

    @Override
    public String toString() {
        return "Goal{" +
                "startingAmount=" + startingAmount +
                ", currentAmount=" + currentAmount +
                ", endGoal=" + endGoal +
                ", goalType=" + goalType +
                ", goalStartDate=" + goalStartDate +
                '}';
    }
}
