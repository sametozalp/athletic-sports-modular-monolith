package com.ozalp.training.business.mappers;

import com.ozalp.training.business.dtos.requests.CreateWorkoutItemTaskRequest;
import com.ozalp.training.models.entities.WorkoutTrainingProgramItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WorkoutTrainingProgramItemMapper {

    WorkoutTrainingProgramItem toEntity(CreateWorkoutItemTaskRequest request);

}
