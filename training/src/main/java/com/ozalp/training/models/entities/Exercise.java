package com.ozalp.training.models.entities;

import com.ozalp.core.models.entites.BaseEntity;
import com.ozalp.training.models.enums.MuscleGroup;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "exercises")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Exercise extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private List<MuscleGroup> muscleGroup;

    @OneToOne(mappedBy = "exercise", cascade = CascadeType.ALL)
    private ExercisePoint exercisePoint;
}