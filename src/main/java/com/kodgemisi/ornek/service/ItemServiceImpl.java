package com.kodgemisi.ornek.service;

import com.kodgemisi.ornek.dto.ItemAddForm;
import com.kodgemisi.ornek.model.Item;
import com.kodgemisi.ornek.repository.ItemRepository;
import com.kodgemisi.ornek.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository, UserRepository userRepository) {
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void addItem(ItemAddForm form) {
        for (int i = 0; i < form.getAmount(); i++) {
            String inventoryCode = Long.toHexString(Double.doubleToLongBits(Math.random())).substring(10); //generate random string
            Item item = new Item(inventoryCode, form.getItemType());
            itemRepository.save(item);
            System.out.println(itemRepository.findOne(item.getId()));

        }
    }
}