package com.ozalp.auth.controllers;

import com.ozalp.auth.business.dtos.requests.CreateRoleRequest;
import com.ozalp.auth.business.services.RoleService;
import com.ozalp.core.utils.consts.ApiConst;
import com.ozalp.core.utils.consts.ApiParams;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(ApiConst.ApiPath.ROLE)
public class RoleController {

    private final RoleService roleService;

    @PostMapping
    ResponseEntity<?> create(@RequestBody @Valid CreateRoleRequest request) {
        return ResponseEntity.ok(roleService.create(request));
    }

    @GetMapping(ApiParams.Base.ALL)
    ResponseEntity<?> getAll() {
        return ResponseEntity.ok(roleService.getAllRoles());
    }
}
