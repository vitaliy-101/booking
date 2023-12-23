package com.example.booking.controllers;


import com.example.booking.dtos.image.ImageDtoIn;
import com.example.booking.dtos.order.OrderDto;
import com.example.booking.dtos.order.OrderDtoIn;
import com.example.booking.enities.Image;
import com.example.booking.enities.Order;
import com.example.booking.mapper.ConvertFromFileToImage;
import com.example.booking.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@Controller

public class ImageController {
    @Autowired
    private ImageService imageService;
    @Autowired
    private ConvertFromFileToImage converter;
    @GetMapping("/images/{id}")
    public ResponseEntity<?> getImageById(@PathVariable Integer id){
        Image image = imageService.getImageById(id);
        return ResponseEntity.ok()
                .header("fileName", image.getOrigFileName())
                .contentType(MediaType.valueOf(image.getContentType()))
                .contentLength(image.getSizeImage())
                .body(new InputStreamResource(new ByteArrayInputStream(image.getBytes())));
    }
    @PostMapping("/image/create/{id}")
    public String createImage(@PathVariable Integer id, MultipartFile file) throws IOException {
        imageService.createImage(converter.convertFromFile(id, file));
        return "redirect:/";
    }



}
