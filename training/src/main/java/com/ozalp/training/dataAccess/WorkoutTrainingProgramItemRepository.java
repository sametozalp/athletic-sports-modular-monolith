package com.ozalp.training.dataAccess;

import com.ozalp.training.models.entities.WorkoutTrainingProgramItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutTrainingProgramItemRepository extends JpaRepository<WorkoutTrainingProgramItem, Integer> {
}
