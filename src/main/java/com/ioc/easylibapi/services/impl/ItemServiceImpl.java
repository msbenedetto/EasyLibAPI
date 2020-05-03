package com.ioc.easylibapi.services.impl;

import com.ioc.easylibapi.models.items.Item;
import com.ioc.easylibapi.repository.ItemRepository;
import com.ioc.easylibapi.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("itemService")
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;


    @Override
    public Item findById(Long id) throws Exception {
        Optional<Item> optional = itemRepository.findById(id);
        if (!optional.isPresent()) {
            throw new Exception("The Item with ID: " + id + "couldn't be found.");
        }
        return optional.get();
    }

    @Override
    public Page<Item> findAll(Specification<Item> specs, Pageable pageable) {
        return itemRepository.findAll(specs, pageable);
    }

    @Override
    public Item insert(Item item) {
        Item createdEntity = itemRepository.save(item);
        return createdEntity;
    }

    @Override
    public Item update(Item item) throws Exception {
        if (item == null || item.getId() == null || item.getId() == 0) {
            throw new Exception("The id couldn't be found or equal to 0.");
        }
        Optional<Item> currentEntity = itemRepository.findById(item.getId());
        if (!currentEntity.isPresent()) {
            throw new Exception("The Item with ID: " + item.getId() + "couldn't be found.");
        }
        Item updatedEntity = itemRepository.save(item);
        return updatedEntity;
    }

    @Override
    public void deleteById(Long id) throws Exception {
        Optional<Item> entityToDelete = itemRepository.findById(id);
        if (!entityToDelete.isPresent()) {
            throw new Exception("The Item with ID: " + id + "couldn't be found.");
        }
        itemRepository.deleteById(id);
    }

}
