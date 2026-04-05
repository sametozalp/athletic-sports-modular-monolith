package com.ozalp.subscription.business.impls;

import com.ozalp.core.managers.BaseImpl;
import com.ozalp.subscription.business.dtos.requests.CreateSubscriptionPlanRequest;
import com.ozalp.subscription.business.mappers.OrganizationSubscriptionMapper;
import com.ozalp.subscription.business.services.OrganizationSubscriptionService;
import com.ozalp.subscription.dataAccess.OrganizationSubscriptionRepository;
import com.ozalp.subscription.models.entities.OrganizationSubscription;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganizationSubscriptionImpl extends BaseImpl<OrganizationSubscription> implements OrganizationSubscriptionService {

    private final OrganizationSubscriptionMapper mapper;
    private final OrganizationSubscriptionRepository repository;

    @Override
    protected JpaRepository<OrganizationSubscription, Integer> getRepository() {
        return repository;
    }

    @Override
    public void create(CreateSubscriptionPlanRequest request) {
        repository.save(mapper.toEntity(request));
    }
}
