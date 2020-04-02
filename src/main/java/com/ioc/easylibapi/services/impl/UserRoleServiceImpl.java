package com.ioc.easylibapi.services.impl;

import com.ioc.easylibapi.models.user.UserRole;
import com.ioc.easylibapi.repository.UserRoleRepository;
import com.ioc.easylibapi.services.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;


    @Override
    public UserRole findById(Long id) throws Exception {
        Optional<UserRole> optional = userRoleRepository.findById(id);
        if (!optional.isPresent()) {
            throw new Exception("The UserRole with ID: " + id + "couldn't be found.");
        }
        return optional.get();
    }

    @Override
    public Page<UserRole> findAll(Specification<UserRole> specs, Pageable pageable) {
        return userRoleRepository.findAll(specs, pageable);
    }

    @Override
    public UserRole insert(UserRole userRole) {
        UserRole createdEntity = userRoleRepository.save(userRole);
        return createdEntity;
    }

    @Override
    public UserRole update(UserRole userRole) throws Exception {
        if (userRole == null || userRole.getId() == null || userRole.getId() == 0) {
            throw new Exception("The id couldn't be found or equal to 0.");
        }
        Optional<UserRole> currentEntity = userRoleRepository.findById(userRole.getId());
        if (!currentEntity.isPresent()) {
            throw new Exception("The UserRole with ID: " + userRole.getId() + "couldn't be found.");
        }
        UserRole updatedEntity = userRoleRepository.save(userRole);
        return updatedEntity;
    }

    @Override
    public void deleteById(Long id) throws Exception {
        Optional<UserRole> entityToDelete = userRoleRepository.findById(id);
        if (!entityToDelete.isPresent()) {
            throw new Exception("The UserRole with ID: " + id + "couldn't be found.");
        }
        userRoleRepository.deleteById(id);
    }

}
