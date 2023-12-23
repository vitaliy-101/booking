package com.example.booking.enities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "active_order")
@Getter
@Setter
public class ActiveOrder{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Long timeOrder;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private MyUser user;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private Order order;
}
