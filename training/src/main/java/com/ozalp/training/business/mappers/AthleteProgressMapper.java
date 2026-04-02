package com.ozalp.training.business.mappers;

import com.ozalp.training.business.dtos.requests.CreateAthleteProgressRequest;
import com.ozalp.training.business.dtos.responses.AthleteProgressResponse;
import com.ozalp.training.models.entities.AthleteProgress;
import com.ozalp.training.models.entities.TrainingProgramItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AthleteProgressMapper {

    AthleteProgressResponse toResponse(AthleteProgress athleteProgress);

    @Mapping(target = "trainingProgramItem", source = "trainingProgramItem")
    @Mapping(target = "organizationId", source = "request.organizationId")
    @Mapping(target = "pointsEarned", source = "trainingProgramItem.point")
    AthleteProgress toEntity(CreateAthleteProgressRequest request, TrainingProgramItem trainingProgramItem);
}
