package com.example.booking.mapper;

import com.example.booking.enities.Image;
import com.example.booking.services.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@Component
public class ConvertFromFileToImage extends DtoConverter{
    @Autowired
    private OrderService orderService;
    public Image convertFromFile(Integer id, MultipartFile file) throws IOException {
        Image image = new Image();
        image.setNameImage(file.getName());
        image.setOrigFileName(file.getOriginalFilename());
        image.setBytes(file.getBytes());
        image.setSizeImage(file.getSize());
        image.setContentType(file.getContentType());
        image.setOrder(orderService.getOrderById(id));
        return image;
    }
}
