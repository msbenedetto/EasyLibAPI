package com.ioc.easylibapi.services.impl;

import com.ioc.easylibapi.models.Role;
import com.ioc.easylibapi.repository.RoleRepository;
import com.ioc.easylibapi.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;


    @Override
    public Role findById(Long id) throws Exception {
        Optional<Role> optional = roleRepository.findById(id);
        if (!optional.isPresent()) {
            throw new Exception("The Role with ID: " + id + "couldn't be found.");
        }
        return optional.get();
    }

    @Override
    public Page<Role> findAll(Specification<Role> specs, Pageable pageable) {
        return roleRepository.findAll(specs, pageable);
    }

    @Override
    public Role insert(Role role) {
        Role createdEntity = roleRepository.save(role);
        return createdEntity;
    }

    @Override
    public Role update(Role role) throws Exception {
        if (role == null || role.getId() == null || role.getId() == 0) {
            throw new Exception("The id couldn't be found or equal to 0.");
        }
        Optional<Role> currentEntity = roleRepository.findById(role.getId());
        if (!currentEntity.isPresent()) {
            throw new Exception("The Role with ID: " + role.getId() + "couldn't be found.");
        }
        Role updatedEntity = roleRepository.save(role);
        return updatedEntity;
    }

    @Override
    public void deleteById(Long id) throws Exception {
        Optional<Role> entityToDelete = roleRepository.findById(id);
        if (!entityToDelete.isPresent()) {
            throw new Exception("The Role with ID: " + id + "couldn't be found.");
        }
        roleRepository.deleteById(id);
    }

}
