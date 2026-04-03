package com.ozalp.membership.business.mappers;

import com.ozalp.auth.models.entities.UserProfile;
import com.ozalp.membership.business.dtos.requests.CreateUserMembershipRequestRequest;
import com.ozalp.membership.business.dtos.responses.UserMembershipRequestResponse;
import com.ozalp.membership.models.entities.UserMembershipRequest;
import com.ozalp.organization.models.entities.Organization;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMembershipRequestMapper {

    UserMembershipRequest toEntity(CreateUserMembershipRequestRequest request);

    @Mapping(target = "id", source = "userMembershipRequest.id")
    @Mapping(target = "organization", source = "organization")
    @Mapping(target = "userProfile", source = "userProfile")
    @Mapping(target = "status", source = "userMembershipRequest.status")
    UserMembershipRequestResponse toResponse(UserMembershipRequest userMembershipRequest, Organization organization, UserProfile userProfile);
}
