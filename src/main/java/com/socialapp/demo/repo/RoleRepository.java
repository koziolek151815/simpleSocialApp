package com.socialapp.demo.repo;

import com.socialapp.demo.model.Role;
import com.socialapp.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findRoleByName(String name);

}
