package com.example.booking.enities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    private Integer price;
    private Integer duration;
    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<Image> images;
    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<ActiveOrder> activeOrders;


}
