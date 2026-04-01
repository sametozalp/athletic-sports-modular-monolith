package com.ozalp.auth.business.mappers;

import com.ozalp.auth.business.dtos.responses.UserRoleResponse;
import com.ozalp.auth.models.entities.UserRole;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserRoleMapper {

    @Mapping(source = "userProfile", target = "user")
    UserRoleResponse toResponse(UserRole userRole);
}
