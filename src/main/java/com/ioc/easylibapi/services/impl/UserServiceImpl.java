package com.ioc.easylibapi.services.impl;

import com.ioc.easylibapi.controller.utils.SearchCriteria;
import com.ioc.easylibapi.controller.utils.UserSearchQueryCriteriaConsumer;
import com.ioc.easylibapi.models.user.User;
import com.ioc.easylibapi.repository.UserRepository;
import com.ioc.easylibapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
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
    public User findByEmail(String email) throws Exception {
        Optional<User> optional = userRepository.findByEmail(email);
        if (!optional.isPresent()) {
            throw new Exception("The User with Email: " + email + " couldn't be found.");
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

    //Test Baeldung
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> searchUser(List<SearchCriteria> params, Pageable pageable) {
        final CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<User> query = builder.createQuery(User.class);
        final Root r = query.from(User.class);

        Predicate predicate = builder.conjunction();
        UserSearchQueryCriteriaConsumer searchConsumer = new UserSearchQueryCriteriaConsumer(predicate, builder, r);
        params.stream().forEach(searchConsumer);
        predicate = searchConsumer.getPredicate();
        query.where(predicate);

        return entityManager.createQuery(query).getResultList();
    }



    @Override
    public void save(final User entity) {
        entityManager.persist(entity);
    }
    //Test Baeldung

}
