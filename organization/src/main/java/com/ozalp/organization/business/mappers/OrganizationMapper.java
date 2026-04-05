package com.ozalp.organization.business.mappers;

import com.ozalp.organization.business.dtos.requests.CreateGymRequest;
import com.ozalp.organization.business.dtos.responses.GymSimpleResponse;
import com.ozalp.organization.models.entities.Organization;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrganizationMapper {

    @Mapping(target = "id", source = "organization.id")
    @Mapping(target = "name", source = "organization.name")
    GymSimpleResponse toResponse(Organization organization);

    @Mapping(target = "ownerUserProfileId", source = "ownerUserProfileId")
    Organization toEntity(CreateGymRequest request);
}
