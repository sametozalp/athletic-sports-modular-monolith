package com.ozalp.training.models.entities;

import com.ozalp.core.models.entites.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "training_programs")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TrainingProgram extends BaseEntity {

    @Column
    private int coachUserProfileId;

    @Column(nullable = false)
    private int athleteUserProfileId;

    @Column
    private String title;

    @Column
    private String description;

    @Column(nullable = false)
    private Instant startDate;

    @Column(nullable = false)
    private Instant endDate;
}