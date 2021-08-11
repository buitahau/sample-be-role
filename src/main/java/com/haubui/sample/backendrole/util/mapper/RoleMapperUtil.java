package com.haubui.sample.backendrole.util.mapper;

import com.haubui.sample.backendrole.domain.Role;
import com.haubui.sample.backendrole.web.rest.dto.RoleDto;
import com.haubui.sample.backendrole.web.rest.response.RoleResponse;
import org.modelmapper.ModelMapper;

public class RoleMapperUtil {

    public static RoleDto parseToDto(Role role) {
        return _modelMapper.map(role, RoleDto.class);
    }

    public static RoleResponse parseToResponse(RoleDto roleDto) {
        return _modelMapper.map(roleDto, RoleResponse.class);
    }

    private static final ModelMapper _modelMapper = new ModelMapper();
}
