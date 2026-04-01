package com.ozalp.healthy_eating_tip.business.mappers;

import com.ozalp.healthy_eating_tip.business.dtos.responses.HealthyEatingTipResponse;
import com.ozalp.healthy_eating_tip.models.entities.HealthyEatingTip;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HealthyEatingTipMapper {

    HealthyEatingTipResponse toResponse(HealthyEatingTip healthyEatingTip);
}
