package com.ozalp.membership.business.mappers;

import com.ozalp.auth.models.entities.UserProfile;
import com.ozalp.membership.business.dtos.requests.CreateUserMembershipRequest;
import com.ozalp.membership.business.dtos.responses.UserMembershipResponse;
import com.ozalp.membership.models.entities.UserMembership;
import com.ozalp.organization.models.entities.Organization;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMembershipMapper {

    @Mapping(target = "organizationId", source = "organizationId")
    @Mapping(target = "userProfileId", source = "userProfileId")
    @Mapping(target = "joinedAt", expression = "java(java.time.Instant.now())")
    UserMembership toEntity(CreateUserMembershipRequest request);

    @Mapping(target = "id", source = "userMembership.id")
    @Mapping(target = "organization", source = "organization")
    @Mapping(target = "userProfile", source = "userProfile")
    UserMembershipResponse toResponse(UserMembership userMembership, Organization organization, UserProfile userProfile);
}
