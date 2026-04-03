package com.ozalp.organization.business.services;

import com.ozalp.organization.business.dtos.requests.CreateGymRequest;
import com.ozalp.organization.business.dtos.responses.GymResponse;

public interface GymService {

    GymResponse create(CreateGymRequest request);

    GymResponse getGymDetail(int id);

}
