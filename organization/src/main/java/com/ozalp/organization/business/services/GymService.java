package com.ozalp.organization.business.services;

import com.ozalp.organization.business.dtos.requests.CreateGymRequest;
import com.ozalp.organization.business.dtos.responses.OrganizationSimpleResponse;
import com.ozalp.organization.models.entities.Gym;

public interface GymService extends OrganizationService<Gym> {

    OrganizationSimpleResponse create(CreateGymRequest request);

}
