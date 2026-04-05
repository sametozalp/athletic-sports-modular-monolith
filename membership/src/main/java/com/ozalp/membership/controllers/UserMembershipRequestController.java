package com.ozalp.membership.controllers;

import com.ozalp.core.utils.consts.ApiConst;
import com.ozalp.membership.business.dtos.requests.CreateUserMembershipRequestRequest;
import com.ozalp.membership.business.services.UserMembershipRequestService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(ApiConst.ApiPath.USER_MEMBERSHIP_REQUEST)
public class UserMembershipRequestController {

    private final UserMembershipRequestService userMembershipRequestService;

    @PostMapping
    ResponseEntity<?> create(@RequestBody @Valid CreateUserMembershipRequestRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userMembershipRequestService.create(request));
    }
}
