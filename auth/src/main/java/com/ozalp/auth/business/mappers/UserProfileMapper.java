package com.ozalp.auth.business.mappers;

import com.ozalp.auth.business.dtos.requests.UpdateProfileRequest;
import com.ozalp.auth.business.dtos.responses.UserProfileSimpleResponse;
import com.ozalp.auth.models.entities.UserProfile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {

    UserProfile toEntity(UpdateProfileRequest request);

    UserProfileSimpleResponse toResponse(UserProfile save);

    void updateEntity(UpdateProfileRequest request,
                      @MappingTarget UserProfile entity);
}
