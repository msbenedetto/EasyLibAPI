package com.ioc.easylibapi.services.impl;

import com.ioc.easylibapi.models.items.Copy;
import com.ioc.easylibapi.repository.CopyRepository;
import com.ioc.easylibapi.services.CopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("copyService")
public class CopyServiceImpl implements CopyService {

    @Autowired
    private CopyRepository copyRepository;


    @Override
    public Copy findById(Long id) throws Exception {
        Optional<Copy> optional = copyRepository.findById(id);
        if (!optional.isPresent()) {
            throw new Exception("The Copy with ID: " + id + "couldn't be found.");
        }
        return optional.get();
    }

    @Override
    public Page<Copy> findAll(Specification<Copy> specs, Pageable pageable) {
        return copyRepository.findAll(specs, pageable);
    }

    @Override
    public Copy insert(Copy copy) {
        Copy createdEntity = copyRepository.save(copy);
        return createdEntity;
    }

    @Override
    public Copy update(Copy copy) throws Exception {
        if (copy == null || copy.getId() == null || copy.getId() == 0) {
            throw new Exception("The id couldn't be found or equal to 0.");
        }
        Optional<Copy> currentEntity = copyRepository.findById(copy.getId());
        if (!currentEntity.isPresent()) {
            throw new Exception("The Copy with ID: " + copy.getId() + "couldn't be found.");
        }
        Copy updatedEntity = copyRepository.save(copy);
        return updatedEntity;
    }

    @Override
    public void deleteById(Long id) throws Exception {
        Optional<Copy> entityToDelete = copyRepository.findById(id);
        if (!entityToDelete.isPresent()) {
            throw new Exception("The Copy with ID: " + id + "couldn't be found.");
        }
        copyRepository.deleteById(id);
    }

    @Override
    public List<Copy> findByLibrary(Long libraryId) {
        return copyRepository.findByLibraryId(libraryId);
    }


}
