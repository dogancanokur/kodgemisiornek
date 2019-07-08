package com.kodgemisi.ornek.controller;

import com.kodgemisi.ornek.model.User;
import com.kodgemisi.ornek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserContoller {

    private final UserService userService;

    @Autowired
    public UserContoller(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView getRegisterPage() {
        return new ModelAndView("register", "user", new User());
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String handleRegisterForm(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register";
        }

        userService.addUser(user);
        return "redirect:/";

    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView getUserPage() {

        return new ModelAndView("users", "users", userService.getUsers());

    }
}
