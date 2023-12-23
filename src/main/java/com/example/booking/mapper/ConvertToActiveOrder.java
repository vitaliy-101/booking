package com.example.booking.mapper;

import com.example.booking.enities.ActiveOrder;
import com.example.booking.enities.MyUser;
import com.example.booking.services.OrderService;
import com.example.booking.services.UserService;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConvertToActiveOrder extends DtoConverter{
    @Autowired
    private OrderService orderService;
    public ActiveOrder convertToActiveOrder(MyUser user, Integer orderId, Long timeOrder){
        ActiveOrder activeOrder = new ActiveOrder();
        activeOrder.setTimeOrder(timeOrder);
        activeOrder.setUser(user);
        activeOrder.setOrder(orderService.getOrderById(orderId));
        return activeOrder;
    }
}
