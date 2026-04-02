package com.ozalp.training.dataAccess;

import com.ozalp.training.models.entities.MealTrainingProgramItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealItemRepository extends JpaRepository<MealTrainingProgramItem, Integer> {
}
