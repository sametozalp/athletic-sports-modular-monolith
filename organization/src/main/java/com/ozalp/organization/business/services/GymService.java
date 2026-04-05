package com.ozalp.organization.business.services;

import com.ozalp.core.services.BaseService;
import com.ozalp.organization.business.dtos.requests.CreateGymRequest;
import com.ozalp.organization.business.dtos.responses.GymSimpleResponse;
import com.ozalp.organization.models.entities.Gym;

public interface GymService extends BaseService<Gym> {

    GymSimpleResponse create(CreateGymRequest request);

    GymSimpleResponse getGymDetail(int id);

}
