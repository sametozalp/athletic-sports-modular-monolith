package com.ozalp.training.business.services;

import com.ozalp.core.services.BaseService;
import com.ozalp.training.business.dtos.requests.CreateMealTrainingProgramItemRequest;
import com.ozalp.training.business.dtos.responses.MealTrainingProgramItemResponse;
import com.ozalp.training.models.entities.MealTrainingProgramItem;

public interface MealTrainingProgramItemService extends BaseService<MealTrainingProgramItem> {

    MealTrainingProgramItemResponse create(CreateMealTrainingProgramItemRequest request);
}
