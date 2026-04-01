package com.ozalp.training.business.dtos.responses;

import com.ozalp.organization.business.dtos.responses.OrganizationResponse;
import com.ozalp.training.models.enums.AthleteProgressStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class AthleteProgressResponse {

    private int id;

    private TrainingItemTaskResponse trainingItemTask;

    private AthleteProgressStatus status;

    private Instant completedAt;

    private int pointsEarned;

    private OrganizationResponse organization;

}
