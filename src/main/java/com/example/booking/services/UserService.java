package com.example.booking.services;

import com.example.booking.enities.ActiveOrder;
import com.example.booking.exceptions.NotFoundByIdException;
import org.springframework.ui.Model;
import com.example.booking.enities.MyUser;
import com.example.booking.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public String createUser(MyUser user, Model model){
        if (userRepository.existsByEmail(user.getEmail())){
            model.addAttribute("errorMessage", "Пользователь с данным email: " + user.getEmail() + " уже существует");
            return "registration";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles("USER");
        userRepository.save(user);
        return "redirect:/login";
    }
    public MyUser findUserByEmail(String email){
        return userRepository.findByEmail(email);
    }
    public List<ActiveOrder> getUserActiveOrders(Integer id){
        return userRepository.findById(id).orElseThrow(() -> new NotFoundByIdException(MyUser.class, id)).getActiveOrders();
    }

}
