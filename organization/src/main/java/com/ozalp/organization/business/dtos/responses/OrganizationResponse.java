package com.ozalp.organization.business.dtos.responses;

import com.ozalp.auth.business.dtos.responses.UserProfileResponse;
import com.ozalp.organization.models.enums.OrganizationStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrganizationResponse {

    private int id;

    private UserProfileResponse owner;

    private String name;

    private String logoUrl;

    private OrganizationStatus status;

}
