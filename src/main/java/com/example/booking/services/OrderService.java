package com.example.booking.services;


import com.example.booking.dtos.order.OrderDto;
import com.example.booking.enities.MyUser;
import com.example.booking.enities.Order;
import com.example.booking.exceptions.NotFoundByIdException;
import com.example.booking.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.security.Principal;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders(){
        return orderRepository.findAll();

    }
    public Order getOrderById(Integer id){
        return orderRepository.findById(id).orElseThrow(() -> new NotFoundByIdException(Order.class, id));
    }

    public void createOrder(Order order){
        orderRepository.save(order);
    }
    public void deleteOrder(Integer id){
        orderRepository.deleteById(id);
    }





}
