package com.example.spyglass.domain.goals.models;

import javax.persistence.*;
import java.util.ArrayList;
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
    private Double leftToBeSaved;
    private Double progressBar;
    private ArrayList<CompletedGoal> completedGoals = new ArrayList<>();

    public Goal() {
    }

    public Goal(Double savedSoFar, Double endGoal, Enum goalType, Date goalStartDate) {
        this.savedSoFar = savedSoFar;
        this.endGoal = endGoal;
        this.goalType = goalType;
        this.goalStartDate = goalStartDate;
    }

    public Long getId() {
        return id;
    }

    public void setProgressBar(Double progressBar) {
        this.progressBar = progressBar;
    }

    public Double getProgressBar() {
        return progressBar;
    }

    public void setProgressBar(double progressBar) {
        this.progressBar = progressBar;
    }

    public Double getLeftToBeSaved() {
        return leftToBeSaved;
    }

    public void setLeftToBeSaved(Double leftToBeSaved) {
        this.leftToBeSaved = leftToBeSaved;
    }

    public ArrayList<CompletedGoal> getCompletedGoals() {
       return completedGoals;
    }

    public void setCompletedGoals(ArrayList<CompletedGoal> completedGoals) {
        this.completedGoals = completedGoals;

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

    public void setId(Long id) {
        this.id = id;
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
