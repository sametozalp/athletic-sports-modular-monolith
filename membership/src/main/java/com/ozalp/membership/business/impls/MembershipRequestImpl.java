package com.ozalp.membership.business.impls;

import com.ozalp.auth.business.services.UserProfileService;
import com.ozalp.auth.models.entities.UserProfile;
import com.ozalp.membership.business.dtos.requests.CreateMembershipRequestRequest;
import com.ozalp.membership.business.dtos.responses.MembershipRequestResponse;
import com.ozalp.membership.business.mappers.UserOrganizationMapper;
import com.ozalp.membership.business.services.MembershipRequestService;
import com.ozalp.membership.dataAccess.MembershipRequestRepository;
import com.ozalp.membership.models.entities.MembershipRequest;
import com.ozalp.organization.business.services.OrganizationService;
import com.ozalp.organization.models.entities.Organization;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MembershipRequestImpl implements MembershipRequestService {

    private final MembershipRequestRepository repository;
    private final UserOrganizationMapper mapper;
    private final OrganizationService organizationService;
    private final UserProfileService userProfileService;

    @Override
    public MembershipRequest findById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User organization not found"));
    }

    @Override
    public MembershipRequest save(MembershipRequest membershipRequest) {
        return repository.save(membershipRequest);
    }

    @Override
    public void delete(int id) {
        MembershipRequest membershipRequest = findById(id);
        membershipRequest.markAsDelete();
        repository.save(membershipRequest);
    }

    @Override
    @Transactional
    public MembershipRequestResponse create(CreateMembershipRequestRequest request) {
        MembershipRequest membershipRequest = mapper.toEntity(request);
        Organization organization = organizationService.findById(request.getOrganizationId());
        UserProfile userProfile = userProfileService.findById(request.getUserProfileId());

//        kafkaTemplate.send(EventConst.Topics.CREATED_MEMBERSHIP, new MembershipRequestCreatedEvent(userProfile.getEmail(), organization.getName())); // update
        return mapper.toResponse(repository.save(membershipRequest), organization, userProfile);
    }
}
