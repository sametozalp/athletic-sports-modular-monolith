package com.ozalp.membership.business.dtos.responses;

import com.ozalp.auth.business.dtos.responses.UserProfileResponse;
import com.ozalp.membership.models.enums.RequestStatus;
import com.ozalp.organization.business.dtos.responses.OrganizationResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MembershipRequestResponse {

    private int id;

    private UserProfileResponse userProfile;

    private OrganizationResponse organization;

    private RequestStatus status;
}
