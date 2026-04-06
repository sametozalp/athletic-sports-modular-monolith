package com.ozalp.subscription.business.impls;

import com.ozalp.core.managers.BaseImpl;
import com.ozalp.subscription.business.dtos.requests.CreateOrganizationSubscriptionPlanRequest;
import com.ozalp.subscription.business.dtos.responses.OrganizationSubscriptionPlanResponse;
import com.ozalp.subscription.business.mappers.OrganizationSubscriptionPlanMapper;
import com.ozalp.subscription.business.services.OrganizationSubscriptionPlanService;
import com.ozalp.subscription.dataAccess.OrganizationSubscriptionPlanRepository;
import com.ozalp.subscription.models.entities.OrganizationSubscriptionPlan;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganizationSubscriptionPlanImpl extends BaseImpl<OrganizationSubscriptionPlan> implements OrganizationSubscriptionPlanService {

    private final OrganizationSubscriptionPlanRepository repository;
    private final OrganizationSubscriptionPlanMapper mapper;

    @Override
    public OrganizationSubscriptionPlanResponse create(CreateOrganizationSubscriptionPlanRequest request) {
        return mapper.toResponse(repository.save(mapper.toEntity(request)));
    }

    @Override
    protected JpaRepository<OrganizationSubscriptionPlan, Integer> getRepository() {
        return repository;
    }
}
