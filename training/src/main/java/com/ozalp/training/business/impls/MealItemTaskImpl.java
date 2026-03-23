package com.ozalp.training.business.impls;

import com.ozalp.core.managers.BaseImpl;
import com.ozalp.training.business.dtos.requests.CreateMealItemTaskRequest;
import com.ozalp.training.business.dtos.responses.MealItemResponse;
import com.ozalp.training.business.mappers.MealItemMapper;
import com.ozalp.training.business.services.AthleteProgressService;
import com.ozalp.training.business.services.MealItemService;
import com.ozalp.training.business.services.TrainingProgramService;
import com.ozalp.training.dataAccess.MealItemRepository;
import com.ozalp.training.models.entities.AthleteProgress;
import com.ozalp.training.models.entities.MealItemTask;
import com.ozalp.training.models.entities.TrainingProgram;
import com.ozalp.training.models.enums.AthleteProgressStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MealItemTaskImpl extends BaseImpl<MealItemTask> implements MealItemService {

    private final MealItemRepository repository;
    private final MealItemMapper mapper;
    private final TrainingProgramService trainingProgramService;
    private final AthleteProgressService athleteProgressService;

    public MealItemTaskImpl(JpaRepository<MealItemTask, Integer> baseRepository, MealItemRepository repository, MealItemMapper mapper, TrainingProgramService trainingProgramService, AthleteProgressService athleteProgressService) {
        super(baseRepository);
        this.repository = repository;
        this.mapper = mapper;
        this.trainingProgramService = trainingProgramService;
        this.athleteProgressService = athleteProgressService;
    }

    @Transactional
    @Override
    public MealItemResponse create(CreateMealItemTaskRequest request) {
        TrainingProgram trainingProgram = trainingProgramService.findById(request.getTrainingProgramId());
        MealItemTask mealItemTask = mapper.toEntity(request);
        mealItemTask.setTrainingProgram(trainingProgram);
        mealItemTask.setDate(request.getDate());

        AthleteProgress athleteProgress = new AthleteProgress(
                mealItemTask,
                AthleteProgressStatus.NOT_COMPLETED,
                null,
                mealItemTask.getPoint()
        );

        athleteProgressService.save(athleteProgress);

        return mapper.toResponse(repository.save(mealItemTask));
    }
}
