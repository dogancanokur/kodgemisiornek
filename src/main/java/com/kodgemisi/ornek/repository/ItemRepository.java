package com.kodgemisi.ornek.repository;

import com.kodgemisi.ornek.model.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {

    Item getItemById(long id);
}
