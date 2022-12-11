package com.broken.storage.controller;

import com.broken.storage.entity.Item;
import com.broken.storage.entity.ItemGroup;
import com.broken.storage.exception.ResourceNotFoundException;
import com.broken.storage.payload.ItemDto;
import com.broken.storage.payload.ItemGroupDto;
import com.broken.storage.repository.ItemGroupRepository;

import com.broken.storage.service.ItemGroupService;

import com.broken.storage.utils.AppConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/itemgroup")
public class ItemGroupController {
    

    private ItemGroupService itemGroupService;
    private ItemGroupRepository itemGroupRepository;

    public ItemGroupController(ItemGroupService itemGroupService,
                          ItemGroupRepository itemGroupRepository){
        this.itemGroupService=itemGroupService;
        this.itemGroupRepository = itemGroupRepository;
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "QuerrySuccessful",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Item.class)) }),
            @ApiResponse(responseCode = "500", description = "QuerryFailed",
                    content = { @Content(mediaType = "application/json") })
    })
    @Operation(summary = "post")
    // Swagger is my number one favorite, it magically worked with older dependencies
    @PostMapping
    public ResponseEntity<ItemGroupDto> createItemGroup(@Valid @RequestBody ItemGroupDto itemGroupDto){
        return new ResponseEntity(itemGroupService.createItemGroup(itemGroupDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ItemGroupDto>> getAllItemGroups(){
        List<ItemGroup> itemGroups = itemGroupService.getItemGroupAll();
        List<ItemGroupDto> itemGroupDtos = new ArrayList<>();
        for (ItemGroup itemGroup : itemGroups){
            itemGroupDtos.add(mapToDto(itemGroup));
        }

        return new ResponseEntity(itemGroupDtos, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ItemGroupDto> getItemById(@PathVariable long id){
        ItemGroup itemGroup = itemGroupRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Item","id",id));

        return new ResponseEntity(mapToDto(itemGroup), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemGroupDto> updateItemById(@PathVariable long id, @Valid @RequestBody ItemGroupDto itemDto){

        return new ResponseEntity<>(itemGroupService.updateItemGroup(itemDto,id), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ItemGroupDto> deleteById(@PathVariable long id){
        itemGroupService.deleteItemGroupById(id);
        return new  ResponseEntity(AppConstants.DELETE_ITEM_GROUP_MESSAGE, HttpStatus.OK);
    }


    private ItemGroupDto mapToDto(ItemGroup itemGroup){
        ItemGroupDto itemGroupDto=new ItemGroupDto();
        itemGroupDto.setId(itemGroup.getId());
        itemGroupDto.setName(itemGroup.getName());
        itemGroupDto.setDescription(itemGroup.getName());


        return itemGroupDto;
    }



}
