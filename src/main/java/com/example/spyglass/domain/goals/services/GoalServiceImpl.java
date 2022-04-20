package com.example.spyglass.domain.goals.services;
import com.example.spyglass.domain.goals.exceptions.GoalNotFoundException;
import com.example.spyglass.domain.goals.models.CompletedGoal;
import com.example.spyglass.domain.goals.models.Goal;

import com.example.spyglass.domain.goals.repos.GoalRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.ArrayList;


@Service
public class GoalServiceImpl implements GoalService{
    private static final Logger logger = LoggerFactory.getLogger(GoalServiceImpl.class);

    private GoalService goalService;

    private GoalRepo goalRepo;

    @Autowired
    public GoalServiceImpl(GoalRepo goalRepo){
        this.goalRepo = goalRepo;
    }

    @Override
    public Goal createGoal(Goal goal) {
//        goal.setLeftToBeSaved(leftToSave(goal.getEndGoal(),goal.getSavedSoFar()));
//        goal.setProgressBar(progressBarCal(goal.getSavedSoFar(),goal.getEndGoal()));
        return goalRepo.save(goal);

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
        Double progressBarCalculation = (savedSoFar / endGoal) * 100;
        logger.info("Calculated progress bar %", progressBarCalculation);
        return progressBarCalculation;
    }

    @Override
    public Double leftToSave(Double endGoal, Double savedSoFar) {
        Double moneyLeftToSave = endGoal - savedSoFar;
        return moneyLeftToSave;
    }

    @Override
    public Double setGoal(Double endGoal) {

        return null;
    }

    @Override
    public ArrayList<CompletedGoal> completedGoals() {
        Goal goal = new Goal();
        return completedGoalsCalculation(goal.getSavedSoFar(),goal.getEndGoal());
    }

    @Override
    public List<Goal> findAllGoals() {
        return (List)goalRepo.findAll();
    }

    public ArrayList<CompletedGoal> completedGoalsCalculation(Double savedSoFar, Double endGoal){
        ArrayList<CompletedGoal> allGoals = new ArrayList<>();
        CompletedGoal completedGoal = new CompletedGoal();
        Goal goal = new Goal();
        goal.setSavedSoFar(savedSoFar);
        goal.setEndGoal(endGoal);
        if(goal.getSavedSoFar().equals(goal.getEndGoal())){
            allGoals.add(completedGoal);
        }
        return allGoals;
    }

}
