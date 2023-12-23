package com.example.booking.enities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "`user`")
@Getter
@Setter
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String userName;
    private String roles;
    private String password;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<ActiveOrder> activeOrders;

}
