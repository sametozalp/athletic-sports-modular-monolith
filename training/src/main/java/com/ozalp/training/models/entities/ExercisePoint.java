package com.ozalp.training.models.entities;

import com.ozalp.core.models.entites.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "exercise_points")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExercisePoint extends BaseEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "exercise_id", nullable = false)
    private Exercise exercise;

    @Column(nullable = false)
    private int point;
}
