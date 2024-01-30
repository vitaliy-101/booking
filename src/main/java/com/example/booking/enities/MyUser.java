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
    @Column(length = 100, unique = true, nullable = false)
    private String email;
    @Column(length = 100)
    private String userName;
    private String roles;
    @Column(length = 100)
    private String password;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<ActiveOrder> activeOrders;

}
