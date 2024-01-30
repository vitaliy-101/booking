package com.example.booking.services;

import com.example.booking.enities.ActiveOrder;
import com.example.booking.repositories.ActiveOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class ActiveOrderService {
    @Autowired
    private ActiveOrderRepository activeOrderRepository;
    @Scheduled(fixedRate = 10000)
    public void deleteOldActiveOrder(){
        List<ActiveOrder> activeOrderList = activeOrderRepository.findAll();
        for (ActiveOrder activeOrder : activeOrderList){
            if (activeOrder.getTimeOrder() <= Instant.now().getEpochSecond() / 60){
                deleteActiveOrderById(activeOrder.getId());
                System.out.println("DELETE");
            }
        }
    }
    public void createActiveOrder(ActiveOrder activeOrder){
        activeOrderRepository.save(activeOrder);
    }
    public void deleteActiveOrderById(Integer id){
        activeOrderRepository.deleteById(id);
    }

}
