package com.ozalp.membership.business.services;

import com.ozalp.core.services.BaseService;
import com.ozalp.membership.business.dtos.requests.CreateUserMembershipRequest;
import com.ozalp.membership.business.dtos.responses.UserMembershipResponse;
import com.ozalp.membership.models.entities.UserMembership;

public interface UserMembershipService extends BaseService<UserMembership> {

    UserMembershipResponse create(CreateUserMembershipRequest request);

}
