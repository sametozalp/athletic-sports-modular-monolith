package com.ozalp.organization.controllers;

import com.ozalp.core.utils.consts.ApiConst;
import com.ozalp.core.utils.consts.ApiParams;
import com.ozalp.organization.business.dtos.requests.CreateGymRequest;
import com.ozalp.organization.business.services.GymService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiConst.ApiPath.GYM)
@RequiredArgsConstructor
public class GymController {

    private final GymService gymService;

    @PostMapping
    ResponseEntity<?> create(@RequestBody @Valid CreateGymRequest request) {
        return ResponseEntity.ok(gymService.create(request));
    }

    @GetMapping(ApiParams.Base.ID)
    ResponseEntity<?> getOrganizationDetail(@PathVariable int id) {
        return ResponseEntity.ok(gymService.getOrganizationSimpleDetail(id));
    }
}
