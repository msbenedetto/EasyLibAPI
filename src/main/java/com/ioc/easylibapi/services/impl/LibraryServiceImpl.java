package com.ioc.easylibapi.services.impl;

import com.ioc.easylibapi.models.library.Library;
import com.ioc.easylibapi.repository.LibraryRepository;
import com.ioc.easylibapi.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("libraryService")
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;


    @Override
    public Library findById(Long id) throws Exception {
        Optional<Library> optional = libraryRepository.findById(id);
        if (!optional.isPresent()) {
            throw new Exception("The Library with ID: " + id + "couldn't be found.");
        }
        return optional.get();
    }

    @Override
    public Page<Library> findAll(Specification<Library> specs, Pageable pageable) {
        return libraryRepository.findAll(specs, pageable);
    }

    @Override
    public Library insert(Library library) {
        Library createdEntity = libraryRepository.save(library);
        return createdEntity;
    }

    @Override
    public Library update(Library library) throws Exception {
        if (library == null || library.getId() == null || library.getId() == 0) {
            throw new Exception("The id couldn't be found or equal to 0.");
        }
        Optional<Library> currentEntity = libraryRepository.findById(library.getId());
        if (!currentEntity.isPresent()) {
            throw new Exception("The Library with ID: " + library.getId() + "couldn't be found.");
        }
        Library updatedEntity = libraryRepository.save(library);
        return updatedEntity;
    }

    @Override
    public void deleteById(Long id) throws Exception {
        Optional<Library> entityToDelete = libraryRepository.findById(id);
        if (!entityToDelete.isPresent()) {
            throw new Exception("The Library with ID: " + id + "couldn't be found.");
        }
        libraryRepository.deleteById(id);
    }

}
