package com.ozalp.healthy_eating_tip.business.impls;

import com.ozalp.core.managers.BaseImpl;
import com.ozalp.healthy_eating_tip.business.dtos.requests.CreateHealthyEatingTipRequest;
import com.ozalp.healthy_eating_tip.business.dtos.responses.HealthyEatingTipResponse;
import com.ozalp.healthy_eating_tip.business.mappers.HealthyEatingTipMapper;
import com.ozalp.healthy_eating_tip.business.services.HealthyEatingTipService;
import com.ozalp.healthy_eating_tip.dataAccess.HealthyEatingTipRepository;
import com.ozalp.healthy_eating_tip.models.entities.HealthyEatingTip;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HealthyEatingTipImpl extends BaseImpl<HealthyEatingTip> implements HealthyEatingTipService {

    private final HealthyEatingTipRepository repository;
    private final HealthyEatingTipMapper mapper;

    @Override
    public HealthyEatingTipResponse create(CreateHealthyEatingTipRequest request) {
        HealthyEatingTip healthyEatingTip = new HealthyEatingTip(request.getTitle(), request.getDescription());
        return mapper.toResponse(repository.save(healthyEatingTip));
    }

    @Override
    public HealthyEatingTipResponse getRandomTip() {
        List<HealthyEatingTip> list = repository.getRandomTip(PageRequest.of(0, 1));
        return list.stream()
                .findFirst()
                .map(mapper::toResponse)
                .orElse(null);
    }

    @Override
    protected JpaRepository<HealthyEatingTip, Integer> getRepository() {
        return repository;
    }
}
