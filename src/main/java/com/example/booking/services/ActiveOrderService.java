package com.example.booking.services;

import com.example.booking.enities.ActiveOrder;
import com.example.booking.repositories.ActiveOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActiveOrderService {
    @Autowired
    private ActiveOrderRepository activeOrderRepository;
    public void createActiveOrder(ActiveOrder activeOrder){
        activeOrderRepository.save(activeOrder);
    }

}
