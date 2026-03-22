package com.ozalp.training.controllers;

import com.ozalp.core.utils.consts.ApiConst;
import com.ozalp.core.utils.consts.ApiParams;
import com.ozalp.training.business.services.TrainingItemTaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiConst.ApiPath.TRAINING_ITEM_TASK)
@RequiredArgsConstructor
public class TrainingItemController {

    private final TrainingItemTaskService trainingItemTaskService;

    @PostMapping(ApiParams.TrainingItem.GET_ALL)
    ResponseEntity<?> getAll() {
        return ResponseEntity.ok(trainingItemTaskService.getAll());
    }
}
