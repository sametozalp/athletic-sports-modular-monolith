package com.ozalp.training.business.dtos.requests;

import com.ozalp.training.models.enums.AthleteProgressStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateStatusAthleteProgressRequest {

    private int id;
    private AthleteProgressStatus status;

}
