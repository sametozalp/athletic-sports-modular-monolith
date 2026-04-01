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

    @Mapping(target = "name", expression = "java(request.getName() != null ? request.getName().trim() : null)")
    @Mapping(target = "surname", expression = "java(request.getSurname() != null ? request.getSurname().trim() : null)")
    @Mapping(target = "phone", expression = "java(request.getPhone() != null ? request.getPhone().trim() : null)")
    void updateEntity(UpdateProfileRequest request,
                      @MappingTarget UserProfile entity);
}
