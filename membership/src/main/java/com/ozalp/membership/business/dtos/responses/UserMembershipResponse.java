package com.ozalp.membership.business.dtos.responses;

import com.ozalp.auth.business.dtos.responses.UserProfileSimpleResponse;
import com.ozalp.organization.business.dtos.responses.OrganizationSimpleResponse;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class UserMembershipResponse {

    private int id;

    private UserProfileSimpleResponse userProfile;

    private OrganizationSimpleResponse organization;

    private Instant joinedAt;

    private Instant leftAt;
}
