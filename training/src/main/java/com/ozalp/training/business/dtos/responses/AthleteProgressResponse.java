package com.ozalp.training.business.dtos.responses;

import com.ozalp.organization.business.dtos.responses.OrganizationSimpleResponse;
import com.ozalp.training.models.enums.AthleteProgressStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class AthleteProgressResponse {

    private int id;

    private TrainingProgramItemResponse trainingItemTask;

    private AthleteProgressStatus status;

    private Instant completedAt;

    private int pointsEarned;

    private OrganizationSimpleResponse organization;

}
