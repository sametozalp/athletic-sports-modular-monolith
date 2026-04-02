package com.ozalp.training.dataAccess;

import com.ozalp.training.models.entities.TrainingProgramItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingItemTaskRepository extends JpaRepository<TrainingProgramItem, Integer> {
}
