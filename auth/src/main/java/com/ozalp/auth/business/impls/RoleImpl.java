package com.ozalp.auth.business.impls;

import com.ozalp.auth.business.dtos.requests.CreateRoleRequest;
import com.ozalp.auth.business.dtos.responses.RoleResponse;
import com.ozalp.auth.business.mappers.RoleMapper;
import com.ozalp.auth.business.services.RoleService;
import com.ozalp.auth.dataAccess.RoleRepository;
import com.ozalp.auth.models.entities.Role;
import com.ozalp.auth.models.enums.RoleEnum;
import com.ozalp.core.managers.BaseImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleImpl extends BaseImpl<Role> implements RoleService {

    private final RoleRepository repository;
    private final RoleMapper mapper;

    @Override
    public Role findByName(RoleEnum roleEnum) {
        return repository.findByName(roleEnum);
    }

    @Override
    public RoleResponse create(CreateRoleRequest request) {
        Role role = mapper.toEntity(request);
        return mapper.toResponse(repository.save(role));
    }

    @Override
    public List<RoleResponse> getAllRoles() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    protected JpaRepository<Role, Integer> getRepository() {
        return repository;
    }
}
