package com.ozalp.healthy_eating_tip.controllers;

import com.ozalp.core.utils.consts.ApiConst;
import com.ozalp.core.utils.consts.ApiParams;
import com.ozalp.healthy_eating_tip.business.dtos.requests.CreateHealthyEatingTipRequest;
import com.ozalp.healthy_eating_tip.business.services.HealthyEatingTipService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiConst.ApiPath.HEALTHY_EATING_TIP)
@RequiredArgsConstructor
public class HealthyEatingTipController {

    private final HealthyEatingTipService healthyEatingTipService;

    @PostMapping
    ResponseEntity<?> create(@RequestBody @Valid CreateHealthyEatingTipRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(healthyEatingTipService.create(request));
    }

    @GetMapping(ApiParams.Base.RANDOM)
    ResponseEntity<?> getRandom() {
        return ResponseEntity.ok(healthyEatingTipService.getRandomTip());
    }
}
