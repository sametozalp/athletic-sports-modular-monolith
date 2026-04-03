package com.ozalp.organization.business.dtos.responses;

import com.ozalp.auth.business.dtos.responses.UserProfileSimpleResponse;
import com.ozalp.organization.models.enums.SubscriptionStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GymResponse {

    private int id;

    private UserProfileSimpleResponse owner;

    private String name;

    private String logoUrl;

    private SubscriptionStatus status;

}
