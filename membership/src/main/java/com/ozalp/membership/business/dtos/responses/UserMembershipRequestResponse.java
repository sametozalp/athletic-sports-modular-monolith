package com.ozalp.membership.business.dtos.responses;

import com.ozalp.auth.business.dtos.responses.UserProfileSimpleResponse;
import com.ozalp.membership.models.enums.RequestStatus;
import com.ozalp.organization.business.dtos.responses.GymSimpleResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserMembershipRequestResponse {

    private int id;

    private UserProfileSimpleResponse userProfile;

    private GymSimpleResponse organization;

    private RequestStatus status;
}
