package com.ozalp.training.controllers;

import com.ozalp.core.utils.consts.ApiConst;
import com.ozalp.training.business.dtos.requests.CreateMealItemTaskRequest;
import com.ozalp.training.business.services.MealTrainingProgramItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiConst.ApiPath.MEAL_ITEM_TASK)
@RequiredArgsConstructor
public class MealItemController {

    private final MealTrainingProgramItemService mealTrainingProgramItemService;

    @PostMapping
    ResponseEntity<?> create(@RequestBody @Valid CreateMealItemTaskRequest request) {
        return ResponseEntity.ok(mealTrainingProgramItemService.create(request));
    }
}
