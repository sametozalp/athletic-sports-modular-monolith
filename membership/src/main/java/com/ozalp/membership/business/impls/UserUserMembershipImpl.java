package com.ozalp.membership.business.impls;

import com.ozalp.auth.business.services.UserProfileService;
import com.ozalp.auth.models.entities.UserProfile;
import com.ozalp.core.managers.BaseImpl;
import com.ozalp.membership.business.dtos.requests.CreateUserMembershipRequest;
import com.ozalp.membership.business.dtos.responses.UserMembershipResponse;
import com.ozalp.membership.business.mappers.UserMembershipMapper;
import com.ozalp.membership.business.services.UserMembershipService;
import com.ozalp.membership.dataAccess.UserMembershipRepository;
import com.ozalp.membership.models.entities.UserMembership;
import com.ozalp.organization.business.services.OrganizationService;
import com.ozalp.organization.models.entities.Organization;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserUserMembershipImpl extends BaseImpl<UserMembership> implements UserMembershipService {

    private final UserMembershipRepository repository;
    private final UserMembershipMapper mapper;
    private final OrganizationService organizationService;
    private final UserProfileService userProfileService;

    @Override
    public UserMembershipResponse create(CreateUserMembershipRequest request) {
        Organization organization = organizationService.findById(request.getOrganizationId());
        UserProfile userProfile = userProfileService.findById(request.getUserProfileId());
        UserMembership userMembership = mapper.toEntity(request);
        return mapper.toResponse(repository.save(userMembership), organization, userProfile);
    }

    @Override
    protected JpaRepository<UserMembership, Integer> getRepository() {
        return repository;
    }
}
