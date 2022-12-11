package com.broken.storage.service;

import com.broken.storage.entity.Item;
import com.broken.storage.payload.ItemDto;

import java.util.List;

public interface ItemService {


    ItemDto createItem(ItemDto itemDto);
    List<Item> getItemAll();
    ItemDto getItemById(long id);
    ItemDto updateItem( ItemDto itemDto,long id);
    void deleteItemById(long id);
}
