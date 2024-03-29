package com.kodgemisi.ornek.controller;

import com.kodgemisi.ornek.dto.ItemAddForm;
import com.kodgemisi.ornek.dto.ItemAssignForm;
import com.kodgemisi.ornek.service.ItemService;
import com.kodgemisi.ornek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ItemController {

    private final ItemService itemService;
    private final UserService userService;

    @Autowired
    public ItemController(ItemService itemService, UserService userService) {
        this.itemService = itemService;
        this.userService = userService;
    }

    @RequestMapping("/items/add")
    public ModelAndView itemAddPage() {
        return new ModelAndView("addItem", "itemForm", new ItemAddForm());
    }

    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public ModelAndView getItems() {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("items", itemService.getItems());
        model.put("usernames", userService.getUsernames());
        model.put("assignForm", new ItemAssignForm());
        ModelAndView modelAndView = new ModelAndView("items", model);

        return modelAndView;
//        return new ModelAndView("items", "items", itemService.getItems());
    }

    @RequestMapping(value = "/items", method = RequestMethod.POST)
    public String handleItemAdd(@Valid @ModelAttribute("itemForm") ItemAddForm form, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "addItem";
        }
        itemService.addItem(form);

        return "redirect:/items";
    }

    @RequestMapping(value = "/items/{id}", method = RequestMethod.PUT)
    public String handleItemAssign(
            @ModelAttribute("user")
                    ItemAssignForm assignForm,
            @PathVariable("id")
                    long id
    ) {
        itemService.assignItem(assignForm.getUsername(), id);
        return "redirect:/items";
    }

    @RequestMapping(value = "/items/{id}", method = RequestMethod.DELETE)
    public String handleItemDelete(@PathVariable Long id) {
        itemService.deleteItemById(id);
        return "redirect:/items";
    }
}