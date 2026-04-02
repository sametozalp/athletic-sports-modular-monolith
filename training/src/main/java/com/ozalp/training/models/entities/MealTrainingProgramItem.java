package com.ozalp.training.models.entities;

import com.ozalp.training.models.enums.MealType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "meal_training_program_items")
@Getter
@Setter
@NoArgsConstructor
public class MealTrainingProgramItem extends TrainingProgramItem {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MealType mealType;

    @Column
    private int calories;
}