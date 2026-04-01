package com.ozalp.auth.business.mappers;

import com.ozalp.auth.business.dtos.requests.RegisterRequest;
import com.ozalp.auth.business.dtos.responses.AuthResponse;
import com.ozalp.auth.models.entities.Auth;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AuthMapper {

    AuthResponse toResponse(Auth auth);

    @Mapping(target = "username", expression = "java(request.getUsername() != null ? request.getUsername().trim() : null)")
    @Mapping(target = "email", expression = "java(request.getEmail() != null ? request.getEmail().trim() : null)")
    Auth toEntity(RegisterRequest request);
}
