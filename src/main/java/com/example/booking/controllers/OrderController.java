package com.example.booking.controllers;


import com.example.booking.dtos.order.OrderDto;
import com.example.booking.dtos.order.OrderDtoIn;

import com.example.booking.enities.Order;
import com.example.booking.mapper.ConvertFromPrincipal;
import com.example.booking.mapper.DtoConverter;

import com.example.booking.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ConvertFromPrincipal converter;
    @Autowired
    private DtoConverter dtoConverter;

    @GetMapping("/")
    public String getPageOrders(Principal principal, Model model){
        model.addAttribute("orders", orderService.getAllOrders());
        model.addAttribute("user", converter.convertFromPrincipal(principal));
        return "orders";
    }

    @GetMapping("/order/{id}")
    public String getOrderInfo(@PathVariable Integer id, Model model){
        model.addAttribute("order", orderService.getOrderById(id));
        return "order-info";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("/admin-orders")
    public String getAdminPageOrders(Principal principal, Model model){
        model.addAttribute("orders", orderService.getAllOrders());
        return "admin-orders";
    }
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("/admin-order/{id}")
    public String getAdminOrderInfo(@PathVariable Integer id, Model model){
        model.addAttribute("order", orderService.getOrderById(id));
        return "admin-order-info";
    }
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping("/admin-order/create")
    public String createOrder(OrderDtoIn order)  {
        orderService.createOrder(dtoConverter.simpleConvert(order, Order.class));
        return "redirect:/admin-orders";
    }
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping("/admin-order/delete/{id}")
    public String deleteOrder(@PathVariable Integer id){
        orderService.deleteOrder(id);
        return "redirect:/admin-orders";
    }
}
