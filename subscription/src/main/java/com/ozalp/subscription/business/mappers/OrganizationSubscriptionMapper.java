package com.ozalp.subscription.business.mappers;

import com.ozalp.subscription.business.dtos.requests.CreateSubscriptionPlanRequest;
import com.ozalp.subscription.models.entities.OrganizationSubscription;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrganizationSubscriptionMapper {

    OrganizationSubscription toEntity(CreateSubscriptionPlanRequest request);
}
