package com.ozalp.organization.business.services;

import com.ozalp.core.services.BaseService;
import com.ozalp.organization.business.dtos.responses.GymResponse;
import com.ozalp.organization.models.entities.Organization;

public interface OrganizationService extends BaseService<Organization> {

    GymResponse getOrganizationDetail(int id);
}
