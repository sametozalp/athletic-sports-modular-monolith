package com.ozalp.auth.business.impls;

import com.ozalp.auth.business.dtos.requests.RegisterRequest;
import com.ozalp.auth.business.dtos.responses.AuthResponse;
import com.ozalp.auth.business.mappers.AuthMapper;
import com.ozalp.auth.business.services.AuthService;
import com.ozalp.auth.business.services.RoleService;
import com.ozalp.auth.business.services.UserRoleService;
import com.ozalp.auth.config.DefaultUserConfig;
import com.ozalp.auth.config.RootAdminConfig;
import com.ozalp.auth.dataAccess.AuthRepository;
import com.ozalp.auth.models.entities.Auth;
import com.ozalp.auth.models.entities.Role;
import com.ozalp.auth.models.entities.UserProfile;
import com.ozalp.auth.models.entities.UserRole;
import com.ozalp.auth.models.enums.RoleEnum;
import com.ozalp.core.managers.BaseImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthImpl extends BaseImpl<Auth> implements AuthService {

    private final AuthRepository repository;
    private final AuthMapper mapper;
    private final RoleService roleService;
    private final UserRoleService userRoleService;
    private final RootAdminConfig rootAdminConfig;
    private final DefaultUserConfig defaultUserConfig;

    @Transactional
    @Override
    public AuthResponse register(RegisterRequest request) {
        Auth reqAuth = mapper.toEntity(request);

        UserProfile profile = new UserProfile();
        profile.setAuth(reqAuth);
        profile.setName(defaultUserConfig.getName());
        reqAuth.setUserProfile(profile);

        return mapper.toResponse(repository.save(reqAuth));
    }

    @Override
    @Transactional
    public void createRootAdmin() {
        Optional<Auth> admin = repository.findByUsername(rootAdminConfig.getUsername());
        if (!admin.isPresent()) {
            Auth auth = new Auth();
            auth.setEmail(rootAdminConfig.getEmail());
            auth.setUsername(rootAdminConfig.getUsername());
            auth.setPassword(rootAdminConfig.getPassword());
            UserProfile userProfile = new UserProfile();
            userProfile.setName(rootAdminConfig.getName());
            auth.setUserProfile(userProfile);
            repository.save(auth);

            roleService.add(new Role(RoleEnum.SUPER_ROOT_ADMIN));
            userRoleService.add(new UserRole(userProfile, roleService.findByName(RoleEnum.SUPER_ROOT_ADMIN)));
        }
    }

    @Override
    protected JpaRepository<Auth, Integer> getRepository() {
        return repository;
    }
}
