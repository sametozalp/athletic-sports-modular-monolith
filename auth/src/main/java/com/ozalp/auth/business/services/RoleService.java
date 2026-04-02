package com.ozalp.auth.business.services;

import com.ozalp.auth.business.dtos.requests.CreateRoleRequest;
import com.ozalp.auth.business.dtos.responses.RoleResponse;
import com.ozalp.auth.models.entities.Role;
import com.ozalp.core.services.BaseService;

import java.util.List;

public interface RoleService extends BaseService<Role> {

    Role findByName(String name);

    RoleResponse create(CreateRoleRequest request);

    List<RoleResponse> getAllRoles();
}
