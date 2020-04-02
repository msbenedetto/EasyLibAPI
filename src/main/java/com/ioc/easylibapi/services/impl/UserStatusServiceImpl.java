package com.ioc.easylibapi.services.impl;

import com.ioc.easylibapi.models.user.UserStatus;
import com.ioc.easylibapi.repository.UserStatusRepository;
import com.ioc.easylibapi.services.UserStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("userStatusService")
public class UserStatusServiceImpl implements UserStatusService {

    @Autowired
    private UserStatusRepository userStatusRepository;


    @Override
    public UserStatus findById(Long id) throws Exception {
        Optional<UserStatus> optional = userStatusRepository.findById(id);
        if (!optional.isPresent()) {
            throw new Exception("The UserStatus with ID: " + id + "couldn't be found.");
        }
        return optional.get();
    }

    @Override
    public Page<UserStatus> findAll(Specification<UserStatus> specs, Pageable pageable) {
        return userStatusRepository.findAll(specs, pageable);
    }

    @Override
    public UserStatus insert(UserStatus userStatus) {
        UserStatus createdEntity = userStatusRepository.save(userStatus);
        return createdEntity;
    }

    @Override
    public UserStatus update(UserStatus userStatus) throws Exception {
        if (userStatus == null || userStatus.getId() == null || userStatus.getId() == 0) {
            throw new Exception("The id couldn't be found or equal to 0.");
        }
        Optional<UserStatus> currentEntity = userStatusRepository.findById(userStatus.getId());
        if (!currentEntity.isPresent()) {
            throw new Exception("The UserStatus with ID: " + userStatus.getId() + "couldn't be found.");
        }
        UserStatus updatedEntity = userStatusRepository.save(userStatus);
        return updatedEntity;
    }

    @Override
    public void deleteById(Long id) throws Exception {
        Optional<UserStatus> entityToDelete = userStatusRepository.findById(id);
        if (!entityToDelete.isPresent()) {
            throw new Exception("The UserStatus with ID: " + id + "couldn't be found.");
        }
        userStatusRepository.deleteById(id);
    }


}
