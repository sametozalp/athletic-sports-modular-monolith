package com.ozalp.training.business.mappers;

import com.ozalp.training.business.dtos.requests.CreateMealTrainingProgramItemRequest;
import com.ozalp.training.business.dtos.responses.MealTrainingProgramItemResponse;
import com.ozalp.training.models.entities.MealTrainingProgramItem;
import com.ozalp.training.models.entities.TrainingProgram;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MealTrainingProgramItemMapper {

    @Mapping(target = "trainingProgram", source = "trainingProgram")
    MealTrainingProgramItem toEntity(CreateMealTrainingProgramItemRequest request, TrainingProgram trainingProgram);

    MealTrainingProgramItemResponse toResponse(MealTrainingProgramItem mealItemTask);
}
