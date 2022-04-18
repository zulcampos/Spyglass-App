package com.example.spyglass.domain.goals.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private String leftToBeSaved;
    private String progressBar;
    private ArrayList<CompletedGoal> completedGoals = new ArrayList<>();

    public Goal() {
    }

    public Long getId() {
        return id;
    }

    public Goal(Double savedSoFar, Double endGoal, Enum goalType, Date goalStartDate) {
        this.savedSoFar = savedSoFar;
        this.endGoal = endGoal;
        this.goalType = goalType;
        this.goalStartDate = goalStartDate;
        this.endGoal = endGoal;
    }

    public String getProgressBar() {
        return progressBar;
    }

    public void setProgressBar(String progressBar) {
        this.progressBar = progressBar;
    }

    public String getLeftToBeSaved() {
        return leftToBeSaved;
    }

    public void setLeftToBeSaved(String leftToBeSaved) {
        this.leftToBeSaved = leftToBeSaved;
    }

    public ArrayList<CompletedGoal> getCompletedGoals() {
       return completedGoals;
    }

    public void setCompletedGoals(ArrayList<CompletedGoal> completedGoals) {
        this.completedGoals = completedGoals;

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
