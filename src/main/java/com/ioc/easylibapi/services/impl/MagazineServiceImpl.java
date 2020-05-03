package com.ioc.easylibapi.services.impl;

import com.ioc.easylibapi.models.items.Magazine;
import com.ioc.easylibapi.repository.MagazineRepository;
import com.ioc.easylibapi.services.MagazineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("magazineService")
public class MagazineServiceImpl implements MagazineService {

    @Autowired
    private MagazineRepository magazineRepository;


    @Override
    public Magazine findById(Long id) throws Exception {
        Optional<Magazine> optional = magazineRepository.findById(id);
        if (!optional.isPresent()) {
            throw new Exception("The Magazine with ID: " + id + "couldn't be found.");
        }
        return optional.get();
    }

    @Override
    public Page<Magazine> findAll(Specification<Magazine> specs, Pageable pageable) {
        return magazineRepository.findAll(specs, pageable);
    }

    @Override
    public Magazine insert(Magazine magazine) {
        Magazine createdEntity = magazineRepository.save(magazine);
        return createdEntity;
    }

    @Override
    public Magazine update(Magazine magazine) throws Exception {
        if (magazine == null || magazine.getId() == null || magazine.getId() == 0) {
            throw new Exception("The id couldn't be found or equal to 0.");
        }
        Optional<Magazine> currentEntity = magazineRepository.findById(magazine.getId());
        if (!currentEntity.isPresent()) {
            throw new Exception("The Magazine with ID: " + magazine.getId() + "couldn't be found.");
        }
        Magazine updatedEntity = magazineRepository.save(magazine);
        return updatedEntity;
    }

    @Override
    public void deleteById(Long id) throws Exception {
        Optional<Magazine> entityToDelete = magazineRepository.findById(id);
        if (!entityToDelete.isPresent()) {
            throw new Exception("The Magazine with ID: " + id + "couldn't be found.");
        }
        magazineRepository.deleteById(id);
    }

}
