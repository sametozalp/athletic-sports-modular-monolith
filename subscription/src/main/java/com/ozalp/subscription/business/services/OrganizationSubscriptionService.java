package com.ozalp.subscription.business.services;

import com.ozalp.core.services.BaseService;
import com.ozalp.subscription.business.dtos.requests.CreateOrganizationSubscription;
import com.ozalp.subscription.models.entities.OrganizationSubscription;

public interface OrganizationSubscriptionService extends BaseService<OrganizationSubscription> {

    void create(CreateOrganizationSubscription request);
}
