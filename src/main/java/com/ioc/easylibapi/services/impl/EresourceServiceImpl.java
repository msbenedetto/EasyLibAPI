package com.ioc.easylibapi.services.impl;

import com.ioc.easylibapi.models.items.Eresource;
import com.ioc.easylibapi.repository.EresourceRepository;
import com.ioc.easylibapi.services.EresourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("eresourceService")
public class EresourceServiceImpl implements EresourceService {

    @Autowired
    private EresourceRepository erRepository;


    @Override
    public Eresource findById(Long id) throws Exception {
        Optional<Eresource> optional = erRepository.findById(id);
        if (!optional.isPresent()) {
            throw new Exception("The Eresource with ID: " + id + "couldn't be found.");
        }
        return optional.get();
    }

    @Override
    public Page<Eresource> findAll(Specification<Eresource> specs, Pageable pageable) {
        return erRepository.findAll(specs, pageable);
    }

    @Override
    public Eresource insert(Eresource er) {
        Eresource createdEntity = erRepository.save(er);
        return createdEntity;
    }

    @Override
    public Eresource update(Eresource er) throws Exception {
        if (er == null || er.getId() == null || er.getId() == 0) {
            throw new Exception("The id couldn't be found or equal to 0.");
        }
        Optional<Eresource> currentEntity = erRepository.findById(er.getId());
        if (!currentEntity.isPresent()) {
            throw new Exception("The Eresource with ID: " + er.getId() + "couldn't be found.");
        }
        Eresource updatedEntity = erRepository.save(er);
        return updatedEntity;
    }

    @Override
    public void deleteById(Long id) throws Exception {
        Optional<Eresource> entityToDelete = erRepository.findById(id);
        if (!entityToDelete.isPresent()) {
            throw new Exception("The Eresource with ID: " + id + "couldn't be found.");
        }
        erRepository.deleteById(id);
    }

}
