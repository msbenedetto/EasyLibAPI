package com.ioc.easylibapi.services.impl;

import com.ioc.easylibapi.models.items.Cd;
import com.ioc.easylibapi.repository.CdRepository;
import com.ioc.easylibapi.services.CdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("cdService")
public class CdServiceImpl implements CdService {

    @Autowired
    private CdRepository cdRepository;


    @Override
    public Cd findById(Long id) throws Exception {
        Optional<Cd> optional = cdRepository.findById(id);
        if (!optional.isPresent()) {
            throw new Exception("The Cd with ID: " + id + "couldn't be found.");
        }
        return optional.get();
    }

    @Override
    public Page<Cd> findAll(Specification<Cd> specs, Pageable pageable) {
        return cdRepository.findAll(specs, pageable);
    }

    @Override
    public Cd insert(Cd cd) {
        Cd createdEntity = cdRepository.save(cd);
        return createdEntity;
    }

    @Override
    public Cd update(Cd cd) throws Exception {
        if (cd == null || cd.getId() == null || cd.getId() == 0) {
            throw new Exception("The id couldn't be found or equal to 0.");
        }
        Optional<Cd> currentEntity = cdRepository.findById(cd.getId());
        if (!currentEntity.isPresent()) {
            throw new Exception("The Cd with ID: " + cd.getId() + "couldn't be found.");
        }
        Cd updatedEntity = cdRepository.save(cd);
        return updatedEntity;
    }

    @Override
    public void deleteById(Long id) throws Exception {
        Optional<Cd> entityToDelete = cdRepository.findById(id);
        if (!entityToDelete.isPresent()) {
            throw new Exception("The Cd with ID: " + id + "couldn't be found.");
        }
        cdRepository.deleteById(id);
    }

}
