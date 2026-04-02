package com.ozalp.training.business.services;

import com.ozalp.core.services.BaseService;
import com.ozalp.training.business.dtos.requests.CreateMealItemTaskRequest;
import com.ozalp.training.business.dtos.responses.MealItemResponse;
import com.ozalp.training.models.entities.MealTrainingProgramItem;

public interface MealTrainingProgramItemService extends BaseService<MealTrainingProgramItem> {

    MealItemResponse create(CreateMealItemTaskRequest request);
}
