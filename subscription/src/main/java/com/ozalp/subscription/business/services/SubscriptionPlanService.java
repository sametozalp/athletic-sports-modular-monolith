package com.ozalp.subscription.business.services;

import com.ozalp.core.services.BaseService;
import com.ozalp.subscription.business.dtos.requests.CreateSubscriptionPlanRequest;
import com.ozalp.subscription.business.dtos.responses.SubscriptionPlanResponse;
import com.ozalp.subscription.models.entities.SubscriptionPlan;

public interface SubscriptionPlanService extends BaseService<SubscriptionPlan> {

    SubscriptionPlanResponse create(CreateSubscriptionPlanRequest request);
}
