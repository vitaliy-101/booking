package com.example.booking.dtos.order;

import com.example.booking.dtos.order.OrderBaseDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDtoIn extends OrderBaseDto {
    private String price;
    private String description;
    private Double duration;
}
