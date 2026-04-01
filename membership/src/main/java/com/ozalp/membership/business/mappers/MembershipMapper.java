package com.ozalp.membership.business.mappers;

import com.ozalp.auth.models.entities.UserProfile;
import com.ozalp.membership.business.dtos.requests.CreateMembershipRequest;
import com.ozalp.membership.business.dtos.responses.MembershipResponse;
import com.ozalp.membership.models.entities.Membership;
import com.ozalp.organization.models.entities.Organization;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MembershipMapper {

    @Mapping(target = "organizationId", source = "organizationId")
    @Mapping(target = "userProfileId", source = "userProfileId")
    @Mapping(target = "joinedAt", expression = "java(java.time.Instant.now())")
    Membership toEntity(CreateMembershipRequest request);

    @Mapping(target = "id", source = "membership.id")
    @Mapping(target = "organization", source = "organization")
    @Mapping(target = "userProfile", source = "userProfile")
    MembershipResponse toResponse(Membership membership, Organization organization, UserProfile userProfile);
}
