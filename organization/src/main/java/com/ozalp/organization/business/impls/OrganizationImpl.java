package com.ozalp.organization.business.impls;

import com.ozalp.auth.business.services.UserProfileService;
import com.ozalp.auth.models.entities.UserProfile;
import com.ozalp.core.managers.BaseImpl;
import com.ozalp.organization.business.dtos.requests.CreateGymRequest;
import com.ozalp.organization.business.dtos.responses.GymResponse;
import com.ozalp.organization.business.mappers.OrganizationMapper;
import com.ozalp.organization.business.services.OrganizationService;
import com.ozalp.organization.dataAccess.OrganizationRepository;
import com.ozalp.organization.models.entities.Organization;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganizationImpl extends BaseImpl<Organization> implements OrganizationService {

    private final OrganizationRepository repository;
    private final OrganizationMapper mapper;
    private final UserProfileService userProfileService;

    @Override
    public GymResponse getOrganizationDetail(int id) {
        Organization organization = findById(id);
        UserProfile owner = userProfileService.findById(organization.getOwnerUserProfileId());
        return mapper.toResponse(organization, owner);
    }

    @Override
    protected JpaRepository<Organization, Integer> getRepository() {
        return repository;
    }
}
