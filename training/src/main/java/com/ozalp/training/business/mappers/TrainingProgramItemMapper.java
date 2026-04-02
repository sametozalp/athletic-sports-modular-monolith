package com.ozalp.training.business.mappers;

import com.ozalp.training.business.dtos.responses.TrainingProgramItemResponse;
import com.ozalp.training.models.entities.TrainingProgramItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TrainingProgramItemMapper {

    TrainingProgramItemResponse toResponse(TrainingProgramItem trainingProgramItem);
}
