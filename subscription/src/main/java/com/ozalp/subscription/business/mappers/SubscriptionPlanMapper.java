package com.ozalp.subscription.business.mappers;

import com.ozalp.subscription.business.dtos.requests.CreateSubscriptionPlanRequest;
import com.ozalp.subscription.business.dtos.responses.SubscriptionPlanResponse;
import com.ozalp.subscription.models.entities.SubscriptionPlan;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubscriptionPlanMapper {

    SubscriptionPlan toEntity(CreateSubscriptionPlanRequest request);

    SubscriptionPlanResponse toResponse(SubscriptionPlan subscriptionPlan);
}
