package com.ozalp.subscription.business.services;

import com.ozalp.subscription.business.dtos.requests.CreateOrganizationSubscriptionPlanRequest;
import com.ozalp.subscription.business.dtos.responses.OrganizationSubscriptionPlanResponse;
import com.ozalp.subscription.models.entities.OrganizationSubscriptionPlan;

public interface OrganizationSubscriptionPlanService extends com.ozalp.core.services.BaseService<OrganizationSubscriptionPlan> {

    OrganizationSubscriptionPlanResponse create(CreateOrganizationSubscriptionPlanRequest request);
}
