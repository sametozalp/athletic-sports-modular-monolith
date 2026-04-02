package com.ozalp.training.dataAccess;

import com.ozalp.training.models.entities.MealTrainingProgramItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealTrainingProgramItemRepository extends JpaRepository<MealTrainingProgramItem, Integer> {
}
