package com.ozalp.training.business.mappers;

import com.ozalp.training.business.dtos.responses.TrainingItemTaskResponse;
import com.ozalp.training.models.entities.TrainingProgramItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TrainingProgramItemMapper {

    TrainingItemTaskResponse toResponse(TrainingProgramItem trainingProgramItem);
}
