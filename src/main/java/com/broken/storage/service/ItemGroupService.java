package com.broken.storage.service;

import com.broken.storage.entity.ItemGroup;
import com.broken.storage.payload.ItemGroupDto;

import java.util.List;

public interface ItemGroupService {

    List<ItemGroup> getItemGroupAll();
    ItemGroupDto createItemGroup(ItemGroupDto itemGroupDto);
    ItemGroupDto getItemGroupById(ItemGroupDto itemGroupDto,long id);
    ItemGroupDto updateItemGroup(ItemGroupDto itemGroupDto,long id);



    void deleteItemGroupById(long id);




}
