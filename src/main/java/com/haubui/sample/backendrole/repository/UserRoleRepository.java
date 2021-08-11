package com.haubui.sample.backendrole.repository;

import com.haubui.sample.backendrole.domain.UserRole;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRole, String>, JpaSpecificationExecutor<UserRole> {

    List<UserRole> findByUserId(String userId);
}
