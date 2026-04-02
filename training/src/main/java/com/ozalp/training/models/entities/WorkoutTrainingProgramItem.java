package com.ozalp.training.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "workout_training_program_items")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WorkoutTrainingProgramItem extends TrainingProgramItem {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "training_program_id", nullable = false)
    private TrainingProgram trainingProgram;

    @Column
    private LocalDate date;

    @Column
    private String coachNote;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exercise_id", nullable = false)
    private Exercise exercise;

    @Column
    private int sets;

    @Column
    private int reps;
}
