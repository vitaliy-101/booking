package com.example.booking.services;

import com.example.booking.enities.Image;
import com.example.booking.exceptions.NotFoundByIdException;
import com.example.booking.repositories.ImageRepository;
import com.example.booking.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;
    public Image getImageById(Integer id){
        return imageRepository.findById(id).orElseThrow(() -> new NotFoundByIdException(Image.class, id));
    }
    public void createImage(Image image){
        imageRepository.save(image);
    }

}
