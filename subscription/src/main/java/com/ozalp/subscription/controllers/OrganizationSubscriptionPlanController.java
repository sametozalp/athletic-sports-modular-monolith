package com.ozalp.subscription.controllers;

import com.ozalp.core.utils.consts.ApiConst;
import com.ozalp.subscription.business.dtos.requests.CreateOrganizationSubscriptionPlanRequest;
import com.ozalp.subscription.business.services.OrganizationSubscriptionPlanService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiConst.ApiPath.SUBSCRIPTION_PLAN)
@RequiredArgsConstructor
public class OrganizationSubscriptionPlanController {

    private final OrganizationSubscriptionPlanService organizationSubscriptionPlanService;

    @PostMapping
    ResponseEntity<?> create(@Valid @RequestBody CreateOrganizationSubscriptionPlanRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(organizationSubscriptionPlanService.create(request));
    }
}