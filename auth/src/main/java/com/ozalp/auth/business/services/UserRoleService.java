package com.ozalp.auth.business.services;

import com.ozalp.auth.business.dtos.requests.CreateUserRoleRequest;
import com.ozalp.auth.business.dtos.responses.UserRoleResponse;
import com.ozalp.auth.models.entities.UserRole;
import com.ozalp.core.services.BaseService;

import java.util.List;

public interface UserRoleService extends BaseService<UserRole> {

    void create(CreateUserRoleRequest request);

    List<UserRoleResponse> getAllRoles(int id);
}
