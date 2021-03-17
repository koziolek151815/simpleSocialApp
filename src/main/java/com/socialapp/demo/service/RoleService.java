package com.socialapp.demo.service;

import com.socialapp.demo.model.Role;
import com.socialapp.demo.repo.RoleRepository;
import org.springframework.stereotype.Service;

@Service(value = "roleService")
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role findByName(String name) {
        return roleRepository.findRoleByName(name);
    }
}
