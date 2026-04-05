package com.ozalp.subscription.business.impls;

import com.ozalp.core.managers.BaseImpl;
import com.ozalp.subscription.business.dtos.requests.CreateSubscriptionPlanRequest;
import com.ozalp.subscription.business.dtos.responses.SubscriptionPlanResponse;
import com.ozalp.subscription.business.mappers.SubscriptionPlanMapper;
import com.ozalp.subscription.business.services.SubscriptionPlanService;
import com.ozalp.subscription.dataAccess.SubscriptionPlanRepository;
import com.ozalp.subscription.models.entities.SubscriptionPlan;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscriptionPlanImpl extends BaseImpl<SubscriptionPlan> implements SubscriptionPlanService {

    private final SubscriptionPlanRepository repository;
    private final SubscriptionPlanMapper mapper;

    @Override
    protected JpaRepository<SubscriptionPlan, Integer> getRepository() {
        return repository;
    }

    @Override
    public SubscriptionPlanResponse create(CreateSubscriptionPlanRequest request) {
        return mapper.toResponse(repository.save(mapper.toEntity(request)));
    }
}
