package com.ozalp.organization.business.services;

import com.ozalp.core.services.BaseService;
import com.ozalp.organization.business.dtos.responses.GymSimpleResponse;
import com.ozalp.organization.models.entities.Organization;

public interface OrganizationService extends BaseService<Organization> {

    GymSimpleResponse getOrganizationDetail(int id);
}
