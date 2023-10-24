package com.api.projects.demo.controller;
import com.api.projects.demo.model.Item;
import com.api.projects.demo.repositary.ItemRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {
    private final ItemRepository itemRepository;

    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }


    @GetMapping
    public ResponseEntity<List<Item>> GetAllItems(){
        List<Item> itemsList =  itemRepository.findAll();
        if (itemsList.isEmpty()) {
            return new ResponseEntity<>(itemsList,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(itemsList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Item>saveItem(@RequestBody Item item){
        Item  savedItem = itemRepository.save(item);
        return new ResponseEntity<>(savedItem,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item>findItemById(@PathVariable("id") String itemId){
        Item existItem = itemRepository.findById(itemId).get();
        if (existItem==null){
            throw new RuntimeException("Item Not Found By itemId:"+itemId);
        }
        return new ResponseEntity<>(existItem, HttpStatus.OK);
    }
}
