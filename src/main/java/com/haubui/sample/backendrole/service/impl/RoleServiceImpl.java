package com.haubui.sample.backendrole.service.impl;

import com.haubui.sample.backendrole.domain.Role;
import com.haubui.sample.backendrole.domain.UserRole;
import com.haubui.sample.backendrole.repository.RoleRepository;
import com.haubui.sample.backendrole.repository.UserRoleRepository;
import com.haubui.sample.backendrole.service.RoleService;
import com.haubui.sample.backendrole.util.mapper.RoleMapperUtil;
import com.haubui.sample.backendrole.web.rest.dto.RoleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Override
    public RoleDto add(RoleDto roleDto) {
        Role role = new Role();
        role.setId(UUID.randomUUID().toString());
        role.setName(roleDto.getName());
        return RoleMapperUtil.parseToDto(_roleRepository.save(role));
    }

    @Override
    public void addRolesToUser(String userId, List<String> roleIds) {
        List<UserRole> userRoles = _userRoleRepository.findByUserId(userId);
        Set<String> deleteUserRoleIds = new HashSet<>();
        Set<String> addUserRoles = new HashSet<>(roleIds);
        for (UserRole userRole : userRoles) {
            String existRoleId = userRole.getRoleId();
            if (roleIds.contains(existRoleId)) {
                addUserRoles.remove(existRoleId);
            } else {
                deleteUserRoleIds.add(userRole.getId());
            }
        }
        for (String userRoleId : deleteUserRoleIds) {
            UserRole userRole = new UserRole();
            userRole.setId(userRoleId);
            _userRoleRepository.delete(userRole);
        }
        for (String roleId : addUserRoles) {
            UserRole userRole = new UserRole();
            userRole.setId(UUID.randomUUID().toString());
            userRole.setRoleId(roleId);
            userRole.setUserId(userId);
            _userRoleRepository.save(userRole);
        }
    }

    @Override
    public List<RoleDto> getRoles(String userId) {
        Set<String> roleIds = _userRoleRepository.findByUserId(userId)
            .stream()
            .map(UserRole::getRoleId)
            .collect(Collectors.toSet());
        List<Role> roles = _roleRepository.findByIdIn(roleIds);
        return roles.stream().map(RoleMapperUtil::parseToDto).collect(Collectors.toList());
    }

    @Autowired
    private RoleRepository _roleRepository;

    @Autowired
    private UserRoleRepository _userRoleRepository;
}
