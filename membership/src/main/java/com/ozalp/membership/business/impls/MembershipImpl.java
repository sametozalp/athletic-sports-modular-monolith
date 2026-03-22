package com.ozalp.membership.business.impls;

import com.ozalp.auth.business.services.UserProfileService;
import com.ozalp.auth.models.entities.UserProfile;
import com.ozalp.membership.business.dtos.requests.CreateMembershipRequest;
import com.ozalp.membership.business.dtos.responses.MembershipResponse;
import com.ozalp.membership.business.mappers.MembershipMapper;
import com.ozalp.membership.business.services.MembershipService;
import com.ozalp.membership.dataAccess.MembershipRepository;
import com.ozalp.membership.models.entities.Membership;
import com.ozalp.organization.business.services.OrganizationService;
import com.ozalp.organization.models.entities.Organization;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MembershipImpl implements MembershipService {

    private final MembershipRepository repository;
    private final MembershipMapper mapper;
    private final OrganizationService organizationService;
    private final UserProfileService userProfileService;

    @Override
    public Membership findById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Membership not found"));
    }

    @Override
    public Membership save(Membership membership) {
        return repository.save(membership);
    }

    @Override
    public void delete(int id) {
        Membership membership = findById(id);
        membership.markAsDelete();
        repository.save(membership);
    }

    @Override
    public MembershipResponse create(CreateMembershipRequest request) {
        Organization organization = organizationService.findById(request.getOrganizationId());
        UserProfile userProfile = userProfileService.findById(request.getUserProfileId());

        Membership membership = mapper.toEntity(request);
        membership.setOrganizationId(organization.getId());
        membership.setUserProfileId(userProfile.getId());

//        kafkaTemplate.send(EventConst.Topics.CREATED_MEMBERSHIP, new MembershipCreatedEvent(userProfile.getEmail(), organization.getName())); // update
        return mapper.toResponse(repository.save(membership), organization, userProfile);
    }
}
