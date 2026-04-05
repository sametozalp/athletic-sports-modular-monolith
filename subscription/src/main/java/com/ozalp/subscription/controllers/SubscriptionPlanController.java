package com.ozalp.subscription.controllers;

import com.ozalp.core.utils.consts.ApiConst;
import com.ozalp.subscription.business.dtos.requests.CreateSubscriptionPlanRequest;
import com.ozalp.subscription.business.services.SubscriptionPlanService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiConst.ApiPath.SUBSCRIPTION_PLAN)
@RequiredArgsConstructor
public class SubscriptionPlanController {

    private final SubscriptionPlanService subscriptionPlanService;

    @PostMapping
    ResponseEntity<?> create(@Valid @RequestBody CreateSubscriptionPlanRequest request) {
        return ResponseEntity.ok(subscriptionPlanService.create(request));
    }
}
