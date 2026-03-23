package com.ozalp.auth.business.impls;

import com.ozalp.auth.business.dtos.requests.RegisterRequest;
import com.ozalp.auth.business.dtos.responses.AuthResponse;
import com.ozalp.auth.business.mappers.AuthMapper;
import com.ozalp.auth.business.services.AuthService;
import com.ozalp.auth.dataAccess.AuthRepository;
import com.ozalp.auth.models.entities.Auth;
import com.ozalp.auth.models.entities.UserProfile;
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

    @Transactional
    @Override
    public AuthResponse register(RegisterRequest request) {
        Auth reqAuth = mapper.toEntity(request);

        UserProfile profile = new UserProfile();
        profile.setAuth(reqAuth);
        profile.setName("user");
        reqAuth.setUserProfile(profile);

        Auth saved = repository.save(reqAuth);
        return mapper.toResponse(saved);
    }

    @Override
    public void createRootAdmin() {
        Optional<Auth> admin = repository.findByUsername("admin");
        if (!admin.isPresent()) {
            Auth auth = new Auth();
            auth.setEmail("admin@gmail.com");
            auth.setUsername("admin");
            auth.setPassword("123456");
            UserProfile userProfile = new UserProfile();
            auth.setUserProfile(userProfile);
            repository.save(auth);
        }
    }

    @Override
    protected JpaRepository<Auth, Integer> getRepository() {
        return repository;
    }
}
