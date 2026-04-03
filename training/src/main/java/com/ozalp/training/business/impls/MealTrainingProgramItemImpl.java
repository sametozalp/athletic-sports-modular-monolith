package com.ozalp.training.business.impls;

import com.ozalp.core.managers.BaseImpl;
import com.ozalp.training.business.dtos.requests.CreateMealTrainingProgramItemRequest;
import com.ozalp.training.business.dtos.responses.MealTrainingProgramItemResponse;
import com.ozalp.training.business.mappers.MealTrainingProgramItemMapper;
import com.ozalp.training.business.services.AthleteProgressService;
import com.ozalp.training.business.services.MealTrainingProgramItemService;
import com.ozalp.training.business.services.TrainingProgramService;
import com.ozalp.training.dataAccess.MealTrainingProgramItemRepository;
import com.ozalp.training.models.entities.AthleteProgress;
import com.ozalp.training.models.entities.MealTrainingProgramItem;
import com.ozalp.training.models.entities.TrainingProgram;
import com.ozalp.training.models.enums.AthleteProgressStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MealTrainingProgramItemImpl extends BaseImpl<MealTrainingProgramItem> implements MealTrainingProgramItemService {

    private final MealTrainingProgramItemRepository repository;
    private final MealTrainingProgramItemMapper mapper;
    private final TrainingProgramService trainingProgramService;
    private final AthleteProgressService athleteProgressService;

    @Transactional
    @Override
    public MealTrainingProgramItemResponse create(CreateMealTrainingProgramItemRequest request) {
        TrainingProgram trainingProgram = trainingProgramService.findById(request.getTrainingProgramId());
        MealTrainingProgramItem mealItemTask = mapper.toEntity(request, trainingProgram);
        AthleteProgress athleteProgress = new AthleteProgress(mealItemTask, AthleteProgressStatus.NOT_COMPLETED, mealItemTask.getPoints());
        athleteProgressService.save(athleteProgress);
        return mapper.toResponse(repository.save(mealItemTask));
    }

    @Override
    protected JpaRepository<MealTrainingProgramItem, Integer> getRepository() {
        return repository;
    }
}
