package com.ozalp.training.dataAccess;

import com.ozalp.training.models.entities.ExercisePoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExercisePointRepository extends JpaRepository<ExercisePoint, Integer> {
}
