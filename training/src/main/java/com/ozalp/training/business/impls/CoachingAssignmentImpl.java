package com.ozalp.training.business.impls;

import com.ozalp.auth.business.services.UserProfileService;
import com.ozalp.auth.models.entities.UserProfile;
import com.ozalp.core.managers.BaseImpl;
import com.ozalp.training.business.dtos.requests.CreateCoachingAssignmentRequest;
import com.ozalp.training.business.services.CoachingAssignmentService;
import com.ozalp.training.dataAccess.CoachingAssignmentRepository;
import com.ozalp.training.models.entities.CoachingAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CoachingAssignmentImpl extends BaseImpl<CoachingAssignment> implements CoachingAssignmentService {

    private final CoachingAssignmentRepository repository;
    private final UserProfileService userProfileService;

    public CoachingAssignmentImpl(JpaRepository<CoachingAssignment, Integer> baseRepository, CoachingAssignmentRepository repository, UserProfileService userProfileService) {
        super(baseRepository);
        this.repository = repository;
        this.userProfileService = userProfileService;
    }

    @Override
    @Transactional
    public void create(CreateCoachingAssignmentRequest request) {
        UserProfile athlete = userProfileService.findById(request.getAthleteUserProfileId());
        UserProfile coach = userProfileService.findById(request.getCoachUserProfileId());
        CoachingAssignment coachingAssignment = new CoachingAssignment(athlete.getId(), coach.getId());
        repository.save(coachingAssignment);
    }
}
