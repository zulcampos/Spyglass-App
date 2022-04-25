package com.example.spyglass.domain.goals.controllers;

import com.example.spyglass.domain.goals.exceptions.GoalNotFoundException;
import com.example.spyglass.domain.goals.models.CompletedGoal;
import com.example.spyglass.domain.goals.models.Goal;
import com.example.spyglass.domain.goals.services.GoalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import java.util.List;

@RestController
@RequestMapping("/goals")
public class GoalController {
    private final Logger logger = LoggerFactory.getLogger(GoalController.class);
    private GoalService goalService;

    @Autowired
    public GoalController(GoalService goalService){
        this.goalService = goalService;
    }
    @PostMapping("")
    public ResponseEntity<Goal> createGoalRequest(@RequestBody Goal goal){
        Goal savedGoal = goalService.createGoal(goal);
        ResponseEntity response = new ResponseEntity(savedGoal, HttpStatus.OK);
        return response;
    }
    @GetMapping("")
    public ResponseEntity<List<Goal>> getAllGoals(){
        List<Goal> goals = goalService.findAllGoals();
        ResponseEntity<List<Goal>> response = new ResponseEntity<>(goals, HttpStatus.CREATED);
        return response;
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getGoalById(@PathVariable Long id) throws GoalNotFoundException {
        try {
            Goal goal = goalService.findById(id);
            ResponseEntity<?> response = new ResponseEntity<>(goal, HttpStatus.OK);
            return response;
        }
        catch (GoalNotFoundException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateGoal(@PathVariable Long id,@RequestBody Goal goal){
        try{
            Goal updatedGoal = goalService.updateGoal(id);
            ResponseEntity response = new ResponseEntity<>(updatedGoal, HttpStatus.OK);
            return response;
        }catch (GoalNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }


    }
}
