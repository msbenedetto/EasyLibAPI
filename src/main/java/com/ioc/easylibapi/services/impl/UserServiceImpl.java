package com.ioc.easylibapi.services.impl;

import com.ioc.easylibapi.models.user.User;
import com.ioc.easylibapi.repository.UserRepository;
import com.ioc.easylibapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User findById(Long id) throws Exception {
        Optional<User> optional = userRepository.findById(id);
        if (!optional.isPresent()) {
            throw new Exception("The User with ID: " + id + "couldn't be found.");
        }
        return optional.get();
    }

    @Override
    public Page<User> findAll(Specification<User> specs, Pageable pageable) {
        return userRepository.findAll(specs, pageable);
    }

    @Override
    public User insert(User user) {
        User createdEntity = userRepository.save(user);
        return createdEntity;
    }

    @Override
    public User update(User user) throws Exception {
        if (user == null || user.getId() == null || user.getId() == 0) {
            throw new Exception("The id couldn't be found or equal to 0.");
        }
        Optional<User> currentEntity = userRepository.findById(user.getId());
        if (!currentEntity.isPresent()) {
            throw new Exception("The User with ID: " + user.getId() + "couldn't be found.");
        }
        User updatedEntity = userRepository.save(user);
        return updatedEntity;
    }

    @Override
    public void deleteById(Long id) throws Exception {
        Optional<User> entityToDelete = userRepository.findById(id);
        if (!entityToDelete.isPresent()) {
            throw new Exception("The User with ID: " + id + "couldn't be found.");
        }
        userRepository.deleteById(id);
    }

}
