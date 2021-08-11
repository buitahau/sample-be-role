package com.haubui.sample.backendrole.web.rest.controller;

import com.haubui.sample.backendrole.service.RoleService;
import com.haubui.sample.backendrole.util.mapper.RoleMapperUtil;
import com.haubui.sample.backendrole.web.rest.dto.RoleDto;
import com.haubui.sample.backendrole.web.rest.response.RoleResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/internal")
public class InternalController {

    @PostMapping("/user/add-roles/{userId}")
    public ResponseEntity<List<RoleResponse>> addRolesToUser(@PathVariable("userId") String userId,
                                                             @RequestBody List<String> roleIds) {
        _roleService.addRolesToUser(userId, roleIds);
        return getRoles(userId);
    }

    @PostMapping("/add")
    public ResponseEntity<RoleResponse> add(@RequestBody RoleDto roleDto) {
        return ResponseEntity.ok(RoleMapperUtil.parseToResponse(_roleService.add(roleDto)));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<RoleResponse>> getRoles(@PathVariable("userId") String userId) {
        List<RoleDto> roleDtos = _roleService.getRoles(userId);
        return ResponseEntity.ok(
            roleDtos
                .stream()
                .map(RoleMapperUtil::parseToResponse)
                .collect(Collectors.toList())
        );
    }

    @Autowired
    private RoleService _roleService;

    private final Logger _log = LoggerFactory.getLogger(InternalController.class);
}
