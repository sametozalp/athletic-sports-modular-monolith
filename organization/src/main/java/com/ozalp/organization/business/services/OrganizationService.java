package com.ozalp.organization.business.services;

import com.ozalp.core.services.BaseService;
import com.ozalp.organization.business.dtos.responses.OrganizationSimpleResponse;
import com.ozalp.organization.models.entities.Organization;

public interface OrganizationService<T extends Organization> extends BaseService<T> {

    OrganizationSimpleResponse getOrganizationSimpleDetail(int id);
}
