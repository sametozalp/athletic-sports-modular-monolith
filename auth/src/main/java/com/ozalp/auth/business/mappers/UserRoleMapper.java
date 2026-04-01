package com.ozalp.auth.business.mappers;

import com.ozalp.auth.business.dtos.responses.UserRoleResponse;
import com.ozalp.auth.models.entities.UserRole;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserRoleMapper {

    UserRoleResponse toResponse(UserRole userRole);
}
