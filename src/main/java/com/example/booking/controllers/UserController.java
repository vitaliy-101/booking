package com.example.booking.controllers;

import com.example.booking.mapper.ConvertFromPrincipal;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import com.example.booking.enities.MyUser;

import com.example.booking.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ConvertFromPrincipal principalConverter;

    @PreAuthorize("hasAnyAuthority('USER')")
    @GetMapping("/active-orders/{id}")
    public String getUserActiveOrders(@PathVariable Integer id, Model model){
        model.addAttribute("activeOrders", userService.getUserActiveOrders(id));
        return "active-orders";
    }

}
