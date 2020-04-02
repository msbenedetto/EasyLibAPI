package com.ioc.easylibapi.services.impl;

import com.ioc.easylibapi.models.items.Dvd;
import com.ioc.easylibapi.repository.DvdRepository;
import com.ioc.easylibapi.services.DvdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("DvdService")
public class DvdServiceImpl implements DvdService {

    @Autowired
    private DvdRepository dvdRepository;


    @Override
    public Dvd findById(Long id) throws Exception {
        Optional<Dvd> optional = dvdRepository.findById(id);
        if (!optional.isPresent()) {
            throw new Exception("The Dvd with ID: " + id + "couldn't be found.");
        }
        return optional.get();
    }

    @Override
    public Page<Dvd> findAll(Specification<Dvd> specs, Pageable pageable) {
        return dvdRepository.findAll(specs, pageable);
    }

    @Override
    public Dvd insert(Dvd dvd) {
        Dvd createdEntity = dvdRepository.save(dvd);
        return createdEntity;
    }

    @Override
    public Dvd update(Dvd dvd) throws Exception {
        if (dvd == null || dvd.getId() == null || dvd.getId() == 0) {
            throw new Exception("The id couldn't be found or equal to 0.");
        }
        Optional<Dvd> currentEntity = dvdRepository.findById(dvd.getId());
        if (!currentEntity.isPresent()) {
            throw new Exception("The Dvd with ID: " + dvd.getId() + "couldn't be found.");
        }
        Dvd updatedEntity = dvdRepository.save(dvd);
        return updatedEntity;
    }

    @Override
    public void deleteById(Long id) throws Exception {
        Optional<Dvd> entityToDelete = dvdRepository.findById(id);
        if (!entityToDelete.isPresent()) {
            throw new Exception("The Dvd with ID: " + id + "couldn't be found.");
        }
        dvdRepository.deleteById(id);
    }

}
