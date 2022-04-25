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
@CrossOrigin("http://localhost:3000")
public class GoalController {
    private final Logger logger = LoggerFactory.getLogger(GoalController.class);
    private GoalService goalService;

    @Autowired
    public GoalController(GoalService goalService){
        this.goalService = goalService;
    }

    @PostMapping("")
    public ResponseEntity<Goal> create(@RequestBody Goal goal) {
        goal = goalService.createGoal(goal);
        return new ResponseEntity<>(goal, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Goal> requestUser(@PathVariable Long id) throws GoalNotFoundException {
        Goal response = goalService.findById(id);
        logger.info(response.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<Goal>> getAll() throws GoalNotFoundException {
        Iterable<Goal> all = goalService.findAllGoals();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<?> updateGoal(@RequestBody Goal goal) {
        try {
            Goal updatedGoal = goalService.updateGoal(goal);
            ResponseEntity response = new ResponseEntity(updatedGoal, HttpStatus.OK);
            return response;
        } catch (GoalNotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGoal(@PathVariable Long id) {
        try {
            goalService.deleteGoal(id);
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .build();
        } catch (GoalNotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }


}
