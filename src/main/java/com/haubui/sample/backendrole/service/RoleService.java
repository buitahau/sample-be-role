package com.haubui.sample.backendrole.service;

import com.haubui.sample.backendrole.web.rest.dto.RoleDto;

import java.util.List;

public interface RoleService {

    RoleDto add(RoleDto roleDto);

    void addRolesToUser(String userId, List<String> roleIds);

    List<RoleDto> getRoles(String userId);
}
