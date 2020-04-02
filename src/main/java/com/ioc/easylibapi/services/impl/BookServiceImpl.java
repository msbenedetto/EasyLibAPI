package com.ioc.easylibapi.services.impl;

import com.ioc.easylibapi.models.items.Book;
import com.ioc.easylibapi.repository.BookRepository;
import com.ioc.easylibapi.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("bookService")
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;


    @Override
    public Book findById(Long id) throws Exception {
        Optional<Book> optional = bookRepository.findById(id);
        if (!optional.isPresent()) {
            throw new Exception("The Book with ID: " + id + "couldn't be found.");
        }
        return optional.get();
    }

    @Override
    public Page<Book> findAll(Specification<Book> specs, Pageable pageable) {
        return bookRepository.findAll(specs, pageable);
    }

    @Override
    public Book insert(Book book) {
        Book createdEntity = bookRepository.save(book);
        return createdEntity;
    }

    @Override
    public Book update(Book book) throws Exception {
        if (book == null || book.getId() == null || book.getId() == 0) {
            throw new Exception("The id couldn't be found or equal to 0.");
        }
        Optional<Book> currentEntity = bookRepository.findById(book.getId());
        if (!currentEntity.isPresent()) {
            throw new Exception("The Book with ID: " + book.getId() + "couldn't be found.");
        }
        Book updatedEntity = bookRepository.save(book);
        return updatedEntity;
    }

    @Override
    public void deleteById(Long id) throws Exception {
        Optional<Book> entityToDelete = bookRepository.findById(id);
        if (!entityToDelete.isPresent()) {
            throw new Exception("The Book with ID: " + id + "couldn't be found.");
        }
        bookRepository.deleteById(id);
    }

}
