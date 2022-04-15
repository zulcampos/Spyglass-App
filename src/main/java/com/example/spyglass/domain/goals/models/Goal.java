package com.example.spyglass.domain.goals.models;

import javax.persistence.*;
import java.util.Date;
@Entity
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Double startingAmount;
    private Double currentAmount;
    private Double endGoal;
    private Enum goalType;
    private Date goalStartDate;
    private Date endGoalDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Goal (){

    }

    public Goal(Double startingAmount, Double endGoal, Enum goalType, Date goalStartDate,Date endGoalDate) {
        this.startingAmount = startingAmount;
        this.endGoal = endGoal;
        this.goalType = goalType;
        this.goalStartDate = goalStartDate;
        this.endGoal = endGoal;
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
