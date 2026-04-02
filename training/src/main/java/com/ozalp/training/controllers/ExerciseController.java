package com.ozalp.training.controllers;

import com.ozalp.core.utils.consts.ApiConst;
import com.ozalp.core.utils.consts.ApiParams;
import com.ozalp.training.business.dtos.requests.CreateExerciseRequest;
import com.ozalp.training.business.services.ExerciseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiConst.ApiPath.EXERCISE)
@RequiredArgsConstructor
public class ExerciseController {

    private final ExerciseService exerciseService;

    @PostMapping
    ResponseEntity<?> create(@RequestBody @Valid CreateExerciseRequest request) {
        return ResponseEntity.ok(exerciseService.create(request));
    }
}
