package com.broken.storage.repository;

import com.broken.storage.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item,Long> {
    Item findById(long id);

}
