package com.example.booking.controllers;

import com.example.booking.enities.ActiveOrder;
import com.example.booking.enities.Order;
import com.example.booking.mapper.ConvertFromPrincipal;
import com.example.booking.mapper.ConvertToActiveOrder;
import com.example.booking.mapper.DateConverter;
import com.example.booking.services.ActiveOrderService;
import jakarta.persistence.Access;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.security.Principal;
import java.sql.Time;
import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Controller
public class ActiveOrderController {
    @Autowired
    private ActiveOrderService activeOrderService;
    @Autowired
    private ConvertFromPrincipal principalConverter;
    @Autowired
    private DateConverter dateConverter;
    @Autowired
    private ConvertToActiveOrder activeOrderConverter;
    @PostMapping("/order-info/create/{id}")
    public String createActiveOrder(Principal principal, @PathVariable Integer id, String date, Model model) throws ParseException {
        if(dateConverter.convertToMinute(date) <= Instant.now().getEpochSecond() / 60 + 120){
            model.addAttribute("errorMessage", "Заказ можно сделать минимум за два часа до мероприятия");
            return "error-date";
        }
        activeOrderService.createActiveOrder(activeOrderConverter.convertToActiveOrder(principalConverter.convertFromPrincipal(principal),
                id, dateConverter.convertToMinute(date)));
        return "redirect:/";
    }



}
