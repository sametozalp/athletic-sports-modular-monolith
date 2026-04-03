package com.ozalp.organization.business.mappers;

import com.ozalp.auth.models.entities.UserProfile;
import com.ozalp.organization.business.dtos.requests.CreateGymRequest;
import com.ozalp.organization.business.dtos.responses.GymResponse;
import com.ozalp.organization.models.entities.Gym;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GymMapper {

    @Mapping(target = "id", source = "gym.id")
    @Mapping(target = "name", source = "gym.name")
    @Mapping(target = "owner", source = "owner")
    GymResponse toResponse(Gym gym, UserProfile owner);

    @Mapping(target = "ownerUserProfileId", source = "ownerUserProfileId")
    Gym toEntity(CreateGymRequest request);

}
