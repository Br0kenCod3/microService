package com.broken.storage.service.impl;

import com.broken.storage.entity.Item;
import com.broken.storage.payload.ItemDto;
import com.broken.storage.repository.ItemRepository;
import com.broken.storage.service.ItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    private ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }


    @Override
    public ItemDto createItem(ItemDto itemDto) {
        Item item = mapToEntity(itemDto);
        Item newItem= itemRepository.save(item);
        return mapToDto(newItem);
    }

    @Override
    public List<Item> getItemAll() {
        return itemRepository.findAll();
    }


    @Override
    public ItemDto getItemById(long id) {
        Item item =itemRepository.findById(id);
        return mapToDto(item);
    }

    @Override
    public ItemDto updateItem( ItemDto itemDto,long id)
    {
        Item item=itemRepository.findById(id);

        item.setName(itemDto.getName());
        item.setDescription(itemDto.getDescription());
        item.setExpiryDates(itemDto.getExpiryDates());
        item.setImportPrice(itemDto.getImportPrice());
        item.setPrice(itemDto.getPrice());
        item.setQuantity(itemDto.getQuantity());
        item.setPhoto(itemDto.getPhoto());
        item.setPlace(itemDto.getPlace());

        Item updatedItem = itemRepository.save(item);
        return mapToDto(updatedItem);
    }

    @Override
    public void deleteItemById(long id) {
        Item item =itemRepository.findById(id);
        itemRepository.delete(item);

    }

    private Item mapToEntity(ItemDto itemDto){
        Item item = new Item();

        item.setName(itemDto.getName());
        item.setDescription(itemDto.getDescription());
        item.setExpiryDates(itemDto.getExpiryDates());
        item.setImportPrice(itemDto.getImportPrice());
        item.setPrice(itemDto.getPrice());
        item.setQuantity(itemDto.getQuantity());
        item.setPhoto(itemDto.getPhoto());
        item.setPlace(itemDto.getPlace());



        return item;
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
