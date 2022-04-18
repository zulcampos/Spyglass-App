package com.example.spyglass.domain.goals.models;

import javax.persistence.*;
import java.util.Date;
@Entity
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Double savedSoFar;
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

    public Goal(Double savedSoFar, Double endGoal, Enum goalType, Date goalStartDate,Date endGoalDate) {
        this.savedSoFar = savedSoFar;
        this.endGoal = endGoal;
        this.goalType = goalType;
        this.goalStartDate = goalStartDate;
        this.endGoal = endGoal;
    }

    public Date getEndGoalDate() {
        return endGoalDate;
    }

    public void setEndGoalDate(Date endGoalDate) {
        this.endGoalDate = endGoalDate;
    }

    public Double getSavedSoFar() {
        return savedSoFar;
    }

    public void setSavedSoFar(Double savedSoFar) {
        this.savedSoFar = savedSoFar;
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
                ", currentAmount=" + savedSoFar +
                ", endGoal=" + endGoal +
                ", goalType=" + goalType +
                ", goalStartDate=" + goalStartDate +
                '}';
    }
}
