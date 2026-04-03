package com.ozalp.organization.business.impls;

import com.ozalp.auth.business.services.UserProfileService;
import com.ozalp.auth.models.entities.UserProfile;
import com.ozalp.core.managers.BaseImpl;
import com.ozalp.organization.business.dtos.requests.CreateGymRequest;
import com.ozalp.organization.business.dtos.responses.GymResponse;
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
        return null;
    }

    @Override
    public GymResponse create(CreateGymRequest request) {
        UserProfile owner = userProfileService.findById(request.getOwnerUserProfileId());
        Gym gym = mapper.toEntity(request);
        return mapper.toResponse(repository.save(gym), owner);
    }

    @Override
    public GymResponse getGymDetail(int id) {
        Gym gym = findById(id);
        UserProfile owner = userProfileService.findById(gym.getOwnerUserProfileId());
        return mapper.toResponse(gym, owner);
    }
}
