package com.ozalp.auth.controllers;

import com.ozalp.auth.business.dtos.requests.CreateUserRoleRequest;
import com.ozalp.auth.business.services.UserRoleService;
import com.ozalp.core.utils.consts.ApiConst;
import com.ozalp.core.utils.consts.ApiParams;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiConst.ApiPath.USER_ROLE)
@RequiredArgsConstructor
public class UserRoleController {

    private final UserRoleService userRoleService;

    @PostMapping
    ResponseEntity<?> create(@RequestBody @Valid CreateUserRoleRequest request) {
        userRoleService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(ApiParams.Base.USER_ID)
    ResponseEntity<?> getAll(@PathVariable int userId) {
        return ResponseEntity.ok(userRoleService.getAllRoles(userId));
    }

    @GetMapping(ApiParams.Base.ID)
    ResponseEntity<?> getDetail(@PathVariable int id) {
        return ResponseEntity.ok(userRoleService.getDetail(id));
    }
}
