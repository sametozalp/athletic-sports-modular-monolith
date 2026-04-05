package com.ozalp.organization.business.impls;

import com.ozalp.auth.business.services.UserProfileService;
import com.ozalp.core.managers.BaseImpl;
import com.ozalp.organization.business.dtos.requests.CreateGymRequest;
import com.ozalp.organization.business.dtos.responses.GymSimpleResponse;
import com.ozalp.organization.business.mappers.GymMapper;
import com.ozalp.organization.business.services.GymService;
import com.ozalp.organization.dataAccess.GymRepository;
import com.ozalp.organization.models.entities.Gym;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GymImpl extends BaseImpl<Gym> implements GymService {

    private final UserProfileService userProfileService;
    private final GymMapper mapper;
    private final GymRepository repository;

    @Override
    protected JpaRepository<Gym, Integer> getRepository() {
        return repository;
    }

    @Override
    public GymSimpleResponse create(CreateGymRequest request) {
        Gym gym = mapper.toEntity(request);
        return mapper.toResponse(repository.save(gym));
    }

    @Override
    public GymSimpleResponse getGymDetail(int id) {
        Gym gym = findById(id);
        return mapper.toResponse(gym);
    }
}
