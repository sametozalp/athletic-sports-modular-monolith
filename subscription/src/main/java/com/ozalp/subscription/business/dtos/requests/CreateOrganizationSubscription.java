package com.ozalp.subscription.business.dtos.requests;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class CreateOrganizationSubscription {

    private int organizationId;

    private Instant endDate;

    private int subscriptionPlanId;

}
