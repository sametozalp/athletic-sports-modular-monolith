package com.ozalp.training.business.services;

import com.ozalp.core.services.BaseService;
import com.ozalp.training.business.dtos.responses.TrainingProgramItemResponse;
import com.ozalp.training.models.entities.TrainingProgramItem;

import java.util.List;

public interface TrainingProgramItemService extends BaseService<TrainingProgramItem> {

    List<TrainingProgramItemResponse> getAll();
}
