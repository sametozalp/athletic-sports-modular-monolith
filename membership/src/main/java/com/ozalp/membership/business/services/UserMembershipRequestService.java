package com.ozalp.membership.business.services;

import com.ozalp.core.services.BaseService;
import com.ozalp.membership.business.dtos.requests.CreateUserMembershipRequestRequest;
import com.ozalp.membership.business.dtos.responses.UserMembershipRequestResponse;
import com.ozalp.membership.models.entities.UserMembershipRequest;

public interface UserMembershipRequestService extends BaseService<UserMembershipRequest> {

    UserMembershipRequestResponse create(CreateUserMembershipRequestRequest request);

}
