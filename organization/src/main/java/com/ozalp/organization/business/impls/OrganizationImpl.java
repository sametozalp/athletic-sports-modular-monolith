package com.ozalp.organization.business.impls;

import com.ozalp.organization.business.dtos.requests.CreateOrganizationRequest;
import com.ozalp.organization.business.dtos.responses.OrganizationResponse;
import com.ozalp.organization.business.mappers.OrganizationMapper;
import com.ozalp.organization.business.services.OrganizationService;
import com.ozalp.organization.dataAccess.OrganizationRepository;
import com.ozalp.organization.models.entities.Organization;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganizationImpl implements OrganizationService {

    private final OrganizationRepository repository;
    private final OrganizationMapper mapper;
//    private final UserProfileClient userProfileClient;
//    private final KafkaTemplate<String, OrganizationCreatedEvent> kafkaTemplate; // update

    @Override
    public Organization findById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Organization not found"));
    }

    @Override
    public Organization save(Organization organization) {
        return repository.save(organization);
    }

    @Override
    public void delete(int id) {
        Organization organization = findById(id);
        organization.markAsDelete();
        repository.save(organization);
    }

    @Override
    public OrganizationResponse create(CreateOrganizationRequest request) {
//        UserProfile owner = userProfileClient.getProfileDetail(request.getOwnerUserProfileId());
//        Organization organization = mapper.toEntity(request);
//        organization.setOwnerUserProfileId(owner.getId());
//
//        kafkaTemplate.send(EventConst.Topics.CREATED_ORGANIZATION, new OrganizationCreatedEvent(owner.getEmail(), organization.getName()));
//        return mapper.toResponse(repository.save(organization), owner);
        return null; // update
    }

    @Override
    public OrganizationResponse getOrganizationDetail(int id) {
//        Organization organization = repository.findById(id).orElseThrow();
//        UserProfile owner = userProfileClient.getProfileDetail(organization.getOwnerUserProfileId());
//        return mapper.toResponse(organization, owner);
        return null; // update
    }
}
