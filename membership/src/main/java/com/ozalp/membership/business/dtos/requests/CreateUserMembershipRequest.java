package com.ozalp.membership.business.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserMembershipRequest {

    private int organizationId;

    private int userProfileId;
}
