package com.example.booking.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class NotFoundByIdException extends EntityNotFoundException {
    public <T> NotFoundByIdException(Class<T> clazz, Integer id){
        super(clazz.getSimpleName() + " by id = " + id + " not found");
    }
}
