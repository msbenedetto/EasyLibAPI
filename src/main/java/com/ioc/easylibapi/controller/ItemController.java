package com.ioc.easylibapi.controller;

import com.ioc.easylibapi.models.items.Item;
import com.ioc.easylibapi.services.ItemService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * Class ItemController
 * core class where are declared the methods allowing to extract / insert / update / delete the item information
 * through @PathVariable() and
 * the @RequestBody
 */
@RestController
@RequestMapping("item")
public class ItemController extends BaseController<Item> {

    @Autowired
    private ItemService itemService;

    @GetMapping("{id}")
    public Item byId(@PathVariable("id") Long id) throws Exception {
        return itemService.findById(id);
    }

    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Item.class)})
    @GetMapping
    public Page<Item> search(@RequestParam(value = "q", required = false, defaultValue = "") String search,
                             @RequestParam(value = "page", required = false, defaultValue = DEFAULT_PAGE) int page,
                             @RequestParam(value = "size", required = false, defaultValue = DEFAULT_SIZE) int size,
                             @RequestParam(value = "sort", required = false, defaultValue = DEFAULT_SORT) String sort,
                             @RequestParam(value = "field", required = false, defaultValue = "id") String field) throws Exception {

        return itemService.findAll(buildSpecification(search), pageRequest(page, size, sort, field));
    }

    @PostMapping
    public Item insert(@RequestBody Item item) {
        return itemService.insert(item);
    }

    @PutMapping
    public Item update(@RequestBody Item item) throws Exception {
        return itemService.update(item);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) throws Exception {
        itemService.deleteById(id);
    }

}
