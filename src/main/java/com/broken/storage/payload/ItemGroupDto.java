package com.broken.storage.payload;


import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ItemGroupDto {
    private  Long id;
    @NotBlank(message = "Item name not set")
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @NotBlank(message = "Item name not set")
    @Column(name = "itemList")
    private String items;
}
