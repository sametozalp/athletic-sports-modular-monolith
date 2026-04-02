package com.ozalp.training.business.mappers;

import com.ozalp.training.business.dtos.requests.CreateMealItemTaskRequest;
import com.ozalp.training.business.dtos.responses.MealItemResponse;
import com.ozalp.training.models.entities.MealTrainingProgramItem;
import com.ozalp.training.models.entities.TrainingProgram;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MealTrainingProgramItemMapper {

    @Mapping(target = "trainingProgram", source = "trainingProgram")
    MealTrainingProgramItem toEntity(CreateMealItemTaskRequest request, TrainingProgram trainingProgram);

    MealItemResponse toResponse(MealTrainingProgramItem mealItemTask);
}
