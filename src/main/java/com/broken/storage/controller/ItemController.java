package com.broken.storage.controller;


import com.broken.storage.entity.Item;
import com.broken.storage.payload.ItemDto;
import com.broken.storage.repository.ItemRepository;
import com.broken.storage.service.ItemService;
import com.broken.storage.utils.AppConstants;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {
    private  ItemService itemService;
    private ItemRepository itemRepository;

    public ItemController(ItemService itemService,
                          ItemRepository itemRepository){
        this.itemService=itemService;
        this.itemRepository = itemRepository;
    }

    @PostMapping
    public ResponseEntity<ItemDto> createItem(@Valid @RequestBody ItemDto itemDto){
        return new ResponseEntity<>(itemService.createItem(itemDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ItemDto>> getAllItems(){
        List<Item> items = itemService.getItemAll();
        List<ItemDto> itemDtos = new ArrayList<>();
        for (Item item : items){
            itemDtos.add(mapToDto(item));
        }

        return new ResponseEntity(itemDtos, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ItemDto> getItemById(@PathVariable long id){
        Item item = itemRepository.findById(id);

        return new ResponseEntity(mapToDto(item), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemDto> updateItemById(@PathVariable long id, @Valid @RequestBody ItemDto itemDto){

        return new ResponseEntity<>(itemService.updateItem(itemDto,id), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ItemDto> deleteById(@PathVariable long id){
        itemService.deleteItemById(id);
        return new  ResponseEntity(AppConstants.DELETE_ITEM_MESSAGE, HttpStatus.OK);
    }


    private ItemDto mapToDto(Item item){
        ItemDto itemDto=new ItemDto();
        itemDto.setId(item.getId());
        itemDto.setName(item.getName());
        itemDto.setDescription(item.getName());
        itemDto.setExpiryDates(item.getExpiryDates());
        itemDto.setImportPrice(item.getImportPrice());
        itemDto.setPrice(item.getPrice());
        itemDto.setQuantity(item.getQuantity());
        itemDto.setPhoto(item.getPhoto());
        itemDto.setPlace(item.getPlace());
        return itemDto;
    }



}
