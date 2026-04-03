package com.ozalp.membership.business.impls;

import com.ozalp.auth.business.services.UserProfileService;
import com.ozalp.auth.models.entities.UserProfile;
import com.ozalp.core.managers.BaseImpl;
import com.ozalp.membership.business.dtos.requests.CreateUserMembershipRequestRequest;
import com.ozalp.membership.business.dtos.responses.UserMembershipRequestResponse;
import com.ozalp.membership.business.mappers.UserMembershipRequestMapper;
import com.ozalp.membership.business.services.UserMembershipRequestService;
import com.ozalp.membership.dataAccess.UserMembershipRequestRepository;
import com.ozalp.membership.models.entities.UserMembershipRequest;
import com.ozalp.organization.business.services.OrganizationService;
import com.ozalp.organization.models.entities.Organization;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserMembershipRequestImpl extends BaseImpl<UserMembershipRequest> implements UserMembershipRequestService {

    private final UserMembershipRequestRepository repository;
    private final UserMembershipRequestMapper mapper;
    private final OrganizationService organizationService;
    private final UserProfileService userProfileService;

    @Override
    public UserMembershipRequestResponse create(CreateUserMembershipRequestRequest request) {
        UserMembershipRequest userMembershipRequest = mapper.toEntity(request);
        Organization organization = organizationService.findById(request.getOrganizationId());
        UserProfile userProfile = userProfileService.findById(request.getUserProfileId());
        return mapper.toResponse(repository.save(userMembershipRequest), organization, userProfile);
    }

    @Override
    protected JpaRepository<UserMembershipRequest, Integer> getRepository() {
        return repository;
    }
}
