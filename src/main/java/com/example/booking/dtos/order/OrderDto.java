package com.example.booking.dtos.order;

import com.example.booking.dtos.order.OrderBaseDto;

import com.example.booking.enities.Image;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderDto extends OrderBaseDto {
    private Integer id;
    private String description;
    private Double duration;
    private List<Image> images;

}
