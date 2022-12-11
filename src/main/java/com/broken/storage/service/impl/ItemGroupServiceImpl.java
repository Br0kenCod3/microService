package com.broken.storage.service.impl;

import com.broken.storage.entity.Item;
import com.broken.storage.entity.ItemGroup;
import com.broken.storage.payload.ItemDto;
import com.broken.storage.payload.ItemGroupDto;
import com.broken.storage.repository.ItemGroupRepository;
import com.broken.storage.repository.ItemRepository;
import com.broken.storage.service.ItemGroupService;
import com.broken.storage.service.ItemService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ItemGroupServiceImpl implements ItemGroupService {

    private ItemGroupRepository itemGroupRepository;

    public ItemGroupServiceImpl(ItemGroupRepository itemGroupRepository) {

        this.itemGroupRepository = itemGroupRepository;
    }


    @Override
    public List<ItemGroup> getItemGroupAll() {
        return itemGroupRepository.findAll();
    }

    @Override
    public ItemGroupDto createItemGroup(ItemGroupDto itemGroupDto) {
        ItemGroup itemGroup = mapToEntity(itemGroupDto);
        ItemGroup newItemGroup= itemGroupRepository.save(itemGroup);
        return mapToDto(newItemGroup);

    }

    @Override
    public ItemGroupDto getItemGroupById(ItemGroupDto itemGroupDto, long id) {
        return null;
    }

    @Override
    public ItemGroupDto updateItemGroup(ItemGroupDto itemGroupDto, long id) {
        return null;
    }

    @Override
    public void deleteItemGroupById(long id) {
        itemGroupRepository.deleteById(id);
    }

    private ItemGroupDto mapToDto(ItemGroup itemGroup){
        ItemGroupDto itemGroupDto=new ItemGroupDto();
        itemGroupDto.setId(itemGroup.getId());
        itemGroupDto.setName(itemGroup.getName());
        itemGroupDto.setDescription(itemGroup.getDescription());
        itemGroupDto.setItems(itemGroup.getItems());

        return itemGroupDto;
    }

    private ItemGroup mapToEntity(ItemGroupDto itemGroupDto){
        ItemGroup itemGroup = new ItemGroup();

        itemGroup.setItems(itemGroupDto.getItems());
        itemGroup.setName(itemGroupDto.getName());
        itemGroup.setDescription(itemGroupDto.getDescription());

        return itemGroup;
    }
}
