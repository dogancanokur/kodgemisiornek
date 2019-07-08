package com.kodgemisi.ornek.service;

import com.kodgemisi.ornek.dto.ItemAddForm;
import com.kodgemisi.ornek.model.Item;

public interface ItemService {
    void addItem(ItemAddForm itemAddForm);

    Iterable<Item> getItems();

    void deleteItemById(Long id);

}
