package com.ozalp.auth.business.impls;

import com.ozalp.auth.business.dtos.requests.CreateRoleRequest;
import com.ozalp.auth.business.dtos.responses.RoleResponse;
import com.ozalp.auth.business.mappers.RoleMapper;
import com.ozalp.auth.business.services.RoleService;
import com.ozalp.auth.dataAccess.RoleRepository;
import com.ozalp.auth.models.entities.Role;
import com.ozalp.core.managers.BaseImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleImpl extends BaseImpl<Role> implements RoleService {

    private final RoleRepository repository;
    private final RoleMapper mapper;

    public RoleImpl(JpaRepository<Role, Integer> baseRepository, RoleRepository repository, RoleMapper mapper) {
        super(baseRepository);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Role findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public RoleResponse create(CreateRoleRequest request) {
        Role role = mapper.toEntity(request);
        return mapper.toResponse(repository.save(role));
    }
}
