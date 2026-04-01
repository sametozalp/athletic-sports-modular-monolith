package com.ozalp.training.business.dtos.responses;

import com.ozalp.auth.business.dtos.responses.UserProfileSimpleResponse;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class TrainingProgramResponse {

    private int id;

    private UserProfileSimpleResponse coach;

    private UserProfileSimpleResponse athlete;

    private String title;

    private String description;

    private Instant startDate;

    private Instant endDate;

}
