package com.ozalp.subscription.controllers;

import com.ozalp.core.utils.consts.ApiConst;
import com.ozalp.subscription.business.dtos.requests.CreateSubscriptionPlanRequest;
import com.ozalp.subscription.business.services.OrganizationSubscriptionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiConst.ApiPath.ORGANIZATION_SUBSCRIPTION)
@RequiredArgsConstructor
public class OrganizationSubscriptionController {

    private final OrganizationSubscriptionService organizationSubscriptionService;

    @PostMapping
    ResponseEntity<?> create(@Valid @RequestBody CreateSubscriptionPlanRequest request) {
        organizationSubscriptionService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
