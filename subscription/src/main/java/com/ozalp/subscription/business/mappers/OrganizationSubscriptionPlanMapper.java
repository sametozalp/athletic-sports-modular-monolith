package com.ozalp.subscription.business.mappers;

import com.ozalp.subscription.business.dtos.requests.CreateOrganizationSubscriptionPlanRequest;
import com.ozalp.subscription.business.dtos.responses.OrganizationSubscriptionPlanResponse;
import com.ozalp.subscription.models.entities.OrganizationSubscriptionPlan;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrganizationSubscriptionPlanMapper {

    OrganizationSubscriptionPlan toEntity(CreateOrganizationSubscriptionPlanRequest request);

    OrganizationSubscriptionPlanResponse toResponse(OrganizationSubscriptionPlan subscriptionPlan);
}
