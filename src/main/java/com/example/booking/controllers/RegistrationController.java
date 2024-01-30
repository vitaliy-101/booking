package com.example.booking.controllers;

import com.example.booking.dtos.user.UserDtoIn;
import com.example.booking.enities.MyUser;
import com.example.booking.mapper.DtoConverter;
import com.example.booking.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;
    @Autowired
    private DtoConverter dtoConverter;
    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String crateUser(@Valid UserDtoIn user, Model model){
        return userService.createUser(dtoConverter.simpleConvert(user, MyUser.class), model);
    }
}
