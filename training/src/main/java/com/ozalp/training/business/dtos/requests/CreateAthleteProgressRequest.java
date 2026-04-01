package com.ozalp.training.business.dtos.requests;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class CreateAthleteProgressRequest {

    private int trainingItemId;

    private Instant completedAt;

    private int organizationId;

}
