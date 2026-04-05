package com.ozalp.subscription.business.mappers;

import com.ozalp.subscription.business.dtos.requests.CreateOrganizationSubscription;
import com.ozalp.subscription.models.entities.OrganizationSubscription;
import com.ozalp.subscription.models.entities.SubscriptionPlan;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrganizationSubscriptionMapper {

    OrganizationSubscription toEntity(CreateOrganizationSubscription request);

    @Mapping(target = "subscriptionPlan", source = "subscriptionPlan")
    OrganizationSubscription toEntity(CreateOrganizationSubscription request, SubscriptionPlan subscriptionPlan);
}
