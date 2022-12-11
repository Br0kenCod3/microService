package com.broken.storage.payload;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ItemDto {

    private  Long id;

    @NotBlank(message = "Item name not set")
    private String name;


    private String description;
    @NotBlank(message = "Item expiryDate not set")
    private String expiryDates;
    @Min(0)
    private int importPrice;
    @Min(1)
    private int price;
    @Min(1)
    private int quantity;
    @NotBlank(message = "Item photo not set")
    private String photo;
    @NotBlank(message = "Item place not set")
    private String place;

}
