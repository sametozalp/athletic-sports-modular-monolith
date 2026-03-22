package com.ozalp.membership.business.dtos.responses;

import com.ozalp.auth.business.dtos.responses.UserProfileResponse;
import com.ozalp.organization.business.dtos.responses.OrganizationResponse;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MembershipResponse {

    private int id;

    private UserProfileResponse userProfile;

    private OrganizationResponse organization;

    private LocalDateTime joinedAt;

    private LocalDateTime leftAt;
}
