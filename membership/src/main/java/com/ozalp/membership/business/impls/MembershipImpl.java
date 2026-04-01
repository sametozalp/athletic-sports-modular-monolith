package com.ozalp.membership.business.impls;

import com.ozalp.auth.business.services.UserProfileService;
import com.ozalp.auth.models.entities.UserProfile;
import com.ozalp.core.managers.BaseImpl;
import com.ozalp.membership.business.dtos.requests.CreateMembershipRequest;
import com.ozalp.membership.business.dtos.responses.MembershipResponse;
import com.ozalp.membership.business.mappers.MembershipMapper;
import com.ozalp.membership.business.services.MembershipService;
import com.ozalp.membership.dataAccess.MembershipRepository;
import com.ozalp.membership.models.entities.Membership;
import com.ozalp.organization.business.services.OrganizationService;
import com.ozalp.organization.models.entities.Organization;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MembershipImpl extends BaseImpl<Membership> implements MembershipService {

    private final MembershipRepository repository;
    private final MembershipMapper mapper;
    private final OrganizationService organizationService;
    private final UserProfileService userProfileService;

    @Override
    public MembershipResponse create(CreateMembershipRequest request) {
        Organization organization = organizationService.findById(request.getOrganizationId());
        UserProfile userProfile = userProfileService.findById(request.getUserProfileId());

        Membership membership = mapper.toEntity(request);

        return mapper.toResponse(repository.save(membership), organization, userProfile);
    }

    @Override
    protected JpaRepository<Membership, Integer> getRepository() {
        return repository;
    }
}
