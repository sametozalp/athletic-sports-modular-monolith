package com.ozalp.training.business.impls;

import com.ozalp.core.managers.BaseImpl;
import com.ozalp.training.business.dtos.requests.CreateWorkoutItemTaskRequest;
import com.ozalp.training.business.mappers.WorkoutTrainingProgramItemMapper;
import com.ozalp.training.business.services.WorkoutTrainingProgramItemService;
import com.ozalp.training.dataAccess.WorkoutTrainingProgramItemRepository;
import com.ozalp.training.models.entities.WorkoutTrainingProgramItem;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkoutTrainingProgramItemImpl extends BaseImpl<WorkoutTrainingProgramItem> implements WorkoutTrainingProgramItemService {

    private final WorkoutTrainingProgramItemRepository repository;
    private final WorkoutTrainingProgramItemMapper mapper;

    @Override
    public void create(CreateWorkoutItemTaskRequest request) {
        add(mapper.toEntity(request));
    }

    @Override
    protected JpaRepository<WorkoutTrainingProgramItem, Integer> getRepository() {
        return repository;
    }
}
