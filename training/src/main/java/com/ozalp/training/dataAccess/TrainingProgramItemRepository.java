package com.ozalp.training.dataAccess;

import com.ozalp.training.models.entities.TrainingProgramItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingProgramItemRepository extends JpaRepository<TrainingProgramItem, Integer> {
}
