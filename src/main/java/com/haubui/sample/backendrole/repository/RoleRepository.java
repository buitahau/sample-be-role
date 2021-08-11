package com.haubui.sample.backendrole.repository;

import com.haubui.sample.backendrole.domain.Role;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface RoleRepository extends CrudRepository<Role, String>, JpaSpecificationExecutor<Role> {

    List<Role> findByIdIn(Set<String> ids);
}
