package com.ozalp.membership.business.impls;

import com.ozalp.auth.business.services.UserProfileService;
import com.ozalp.auth.models.entities.UserProfile;
import com.ozalp.core.managers.BaseImpl;
import com.ozalp.membership.business.dtos.requests.CreateMembershipRequestRequest;
import com.ozalp.membership.business.dtos.responses.MembershipRequestResponse;
import com.ozalp.membership.business.mappers.UserOrganizationMapper;
import com.ozalp.membership.business.services.MembershipRequestService;
import com.ozalp.membership.dataAccess.MembershipRequestRepository;
import com.ozalp.membership.models.entities.MembershipRequest;
import com.ozalp.organization.business.services.OrganizationService;
import com.ozalp.organization.models.entities.Organization;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MembershipRequestImpl extends BaseImpl<MembershipRequest> implements MembershipRequestService {

    private final MembershipRequestRepository repository;
    private final UserOrganizationMapper mapper;
    private final OrganizationService organizationService;
    private final UserProfileService userProfileService;

    @Override
    @Transactional
    public MembershipRequestResponse create(CreateMembershipRequestRequest request) {
        MembershipRequest membershipRequest = mapper.toEntity(request);
        Organization organization = organizationService.findById(request.getOrganizationId());
        UserProfile userProfile = userProfileService.findById(request.getUserProfileId());

        return mapper.toResponse(repository.save(membershipRequest), organization, userProfile);
    }

    @Override
    protected JpaRepository<MembershipRequest, Integer> getRepository() {
        return repository;
    }
}
