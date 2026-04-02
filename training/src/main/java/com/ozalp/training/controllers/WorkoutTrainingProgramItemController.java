package com.ozalp.training.controllers;

import com.ozalp.core.utils.consts.ApiConst;
import com.ozalp.training.business.dtos.requests.CreateWorkoutItemTaskRequest;
import com.ozalp.training.business.services.WorkoutTrainingProgramItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiConst.ApiPath.WORKOUT_TRAINING_PROGRAM_ITEM)
@RequiredArgsConstructor
public class WorkoutTrainingProgramItemController {

    private final WorkoutTrainingProgramItemService workoutTrainingProgramItemService;

    @PostMapping
    ResponseEntity<?> create(@Valid @RequestBody CreateWorkoutItemTaskRequest request) {
        workoutTrainingProgramItemService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
