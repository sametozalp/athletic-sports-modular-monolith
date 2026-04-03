package com.ozalp.organization.business.services;

import com.ozalp.core.services.BaseService;
import com.ozalp.organization.business.dtos.requests.CreateGymRequest;
import com.ozalp.organization.business.dtos.responses.GymResponse;
import com.ozalp.organization.models.entities.Gym;

public interface GymService extends BaseService<Gym> {

    GymResponse create(CreateGymRequest request);

    GymResponse getGymDetail(int id);

}
