package com.example.spyglass.domain.goals.repos;

import com.example.spyglass.domain.goals.models.Goal;
import org.springframework.data.repository.CrudRepository;

public interface GoalRepo extends CrudRepository<Goal,Long> {

}
