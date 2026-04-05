package com.ozalp.organization.business.mappers;

import com.ozalp.organization.business.dtos.requests.CreateGymRequest;
import com.ozalp.organization.business.dtos.responses.OrganizationSimpleResponse;
import com.ozalp.organization.models.entities.Gym;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GymMapper {

    @Mapping(target = "id", source = "gym.id")
    @Mapping(target = "name", source = "gym.name")
    OrganizationSimpleResponse toResponse(Gym gym);

    @Mapping(target = "ownerUserProfileId", source = "ownerUserProfileId")
    Gym toEntity(CreateGymRequest request);

}
