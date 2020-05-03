package com.ioc.easylibapi.controller;

import com.ioc.easylibapi.models.items.Book;
import com.ioc.easylibapi.services.BookService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * Class BookController
 * core class where are declared the methods allowing to extract / insert / update / delete the book information
 * through @PathVariable() and
 * the @RequestBody
 */
@RestController
@RequestMapping("book")
public class BookController extends BaseController<Book> {

    @Autowired
    private BookService bookService;

    @GetMapping("{id}")
    public Book byId(@PathVariable("id") Long id) throws Exception {
        return bookService.findById(id);
    }

    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Book.class)})
    @GetMapping
    public Page<Book> search(@RequestParam(value = "q", required = false, defaultValue = "") String search,
                             @RequestParam(value = "page", required = false, defaultValue = DEFAULT_PAGE) int page,
                             @RequestParam(value = "size", required = false, defaultValue = DEFAULT_SIZE) int size,
                             @RequestParam(value = "sort", required = false, defaultValue = DEFAULT_SORT) String sort,
                             @RequestParam(value = "field", required = false, defaultValue = "id") String field) throws Exception {

        return bookService.findAll(buildSpecification(search), pageRequest(page, size, sort, field));
    }

    @PostMapping
    public Book insert(@RequestBody Book book) {
        return bookService.insert(book);
    }

    @PutMapping
    public Book update(@RequestBody Book book) throws Exception {
        return bookService.update(book);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) throws Exception {
        bookService.deleteById(id);
    }

}
