package com.ozalp.training.business.dtos.responses;

import com.ozalp.auth.business.dtos.responses.UserProfileSimpleResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CoachingAssignmentResponse {

    private int id;
    private UserProfileSimpleResponse athleteUserProfile;
    private UserProfileSimpleResponse coachUserProfile;
}
