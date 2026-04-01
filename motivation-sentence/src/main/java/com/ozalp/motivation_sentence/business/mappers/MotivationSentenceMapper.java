package com.ozalp.motivation_sentence.business.mappers;

import com.ozalp.motivation_sentence.business.dtos.MotivationSentenceResponse;
import com.ozalp.motivation_sentence.models.entities.MotivationSentence;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MotivationSentenceMapper {

    MotivationSentenceResponse toResponse(MotivationSentence motivationSentence);
}
