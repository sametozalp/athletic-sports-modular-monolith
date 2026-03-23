package com.ozalp.training.business.impls;

import com.ozalp.auth.business.services.UserProfileService;
import com.ozalp.auth.models.entities.UserProfile;
import com.ozalp.core.managers.BaseImpl;
import com.ozalp.mail.services.EmailService;
import com.ozalp.training.business.dtos.requests.CreateTrainingProgramRequest;
import com.ozalp.training.business.dtos.responses.TrainingProgramResponse;
import com.ozalp.training.business.mappers.TrainingProgramMapper;
import com.ozalp.training.business.services.TrainingProgramService;
import com.ozalp.training.dataAccess.TrainingProgramRepository;
import com.ozalp.training.models.entities.TrainingProgram;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TrainingProgramImpl extends BaseImpl<TrainingProgram> implements TrainingProgramService {

    private final TrainingProgramRepository repository;
    private final TrainingProgramMapper mapper;
    private final UserProfileService userProfileService;
    private final EmailService emailService;

    @Override
    @Transactional
    public TrainingProgramResponse create(CreateTrainingProgramRequest request) {
        UserProfile athlete = userProfileService.findById(request.getAthleteUserProfileId());
        UserProfile coach = userProfileService.findById(request.getCoachUserProfileId());

        TrainingProgram trainingProgram = mapper.toEntity(request);
        trainingProgram.setAthleteUserProfileId(athlete.getId());
        trainingProgram.setCoachUserProfileId(coach.getId());
        return mapper.toResponse(repository.save(trainingProgram), athlete, coach);
    }

    @Override
    protected JpaRepository<TrainingProgram, Integer> getRepository() {
        return repository;
    }
}
