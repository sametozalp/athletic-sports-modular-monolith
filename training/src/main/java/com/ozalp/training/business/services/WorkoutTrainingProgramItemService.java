package com.ozalp.training.business.services;

import com.ozalp.core.services.BaseService;
import com.ozalp.training.business.dtos.requests.CreateWorkoutItemTaskRequest;
import com.ozalp.training.models.entities.WorkoutTrainingProgramItem;

public interface WorkoutTrainingProgramItemService extends BaseService<WorkoutTrainingProgramItem> {

    void create(CreateWorkoutItemTaskRequest request);
}
