package com.ozalp.training.business.mappers;

import com.ozalp.training.business.dtos.responses.AthleteProgressResponse;
import com.ozalp.training.models.entities.AthleteProgress;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AthleteProgressMapper {

    AthleteProgressResponse toResponse(AthleteProgress athleteProgress);

}
