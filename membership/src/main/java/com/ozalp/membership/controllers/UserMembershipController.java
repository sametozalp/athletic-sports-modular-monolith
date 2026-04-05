package com.ozalp.membership.controllers;

import com.ozalp.core.utils.consts.ApiConst;
import com.ozalp.membership.business.dtos.requests.CreateUserMembershipRequest;
import com.ozalp.membership.business.services.UserMembershipService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiConst.ApiPath.USER_MEMBERSHIP)
@RequiredArgsConstructor
public class UserMembershipController {

    private final UserMembershipService userMembershipService;

    @PostMapping
    ResponseEntity<?> create(@RequestBody @Valid CreateUserMembershipRequest request) {
        return ResponseEntity.ok(userMembershipService.create(request));
    }
}
