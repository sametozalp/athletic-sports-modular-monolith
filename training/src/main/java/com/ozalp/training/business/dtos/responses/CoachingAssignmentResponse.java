package com.ozalp.training.business.dtos.responses;

import com.ozalp.auth.business.dtos.responses.UserProfileResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CoachingAssignmentResponse {

    private int id;
    private UserProfileResponse athleteUserProfile;
    private UserProfileResponse coachUserProfile;
}
