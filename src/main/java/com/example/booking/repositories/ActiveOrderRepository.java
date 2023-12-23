package com.example.booking.repositories;

import com.example.booking.enities.ActiveOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActiveOrderRepository extends JpaRepository<ActiveOrder, Integer> {
}
