package com.ozalp.auth.controllers;

import com.ozalp.auth.business.dtos.requests.CreateRoleRequest;
import com.ozalp.auth.business.services.RoleService;
import com.ozalp.core.utils.consts.ApiConst;
import com.ozalp.core.utils.consts.ApiParams;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(ApiConst.ApiPath.ROLE)
public class RoleController {

    private final RoleService roleService;

    @PostMapping(ApiParams.Base.CREATE)
    ResponseEntity<?> create(@RequestBody @Valid CreateRoleRequest request) {
        return ResponseEntity.ok(roleService.create(request));
    }
}
