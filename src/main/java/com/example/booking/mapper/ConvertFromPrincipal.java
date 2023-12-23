package com.example.booking.mapper;

import com.example.booking.enities.MyUser;
import com.example.booking.repositories.UserRepository;
import com.example.booking.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.Principal;

@Component
public class ConvertFromPrincipal extends DtoConverter{
    @Autowired
    private UserService userService;
    public MyUser convertFromPrincipal(Principal principal){
        return userService.findUserByEmail(principal.getName());
    }
}
