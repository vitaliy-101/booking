package com.example.booking.exceptions;

import com.example.booking.dtos.ErrorDto;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDto> handleNotFoundException(WebRequest request, EntityNotFoundException exception){
        log.error(request.getDescription(false) + " Exception: " + exception.getMessage());
        return toError(HttpStatus.NOT_FOUND, new ErrorDto(exception.getMessage()));
    }
    private ResponseEntity<ErrorDto> toError(HttpStatus httpStatus, ErrorDto errorDto){
        return ResponseEntity.status(httpStatus).contentType(MediaType.APPLICATION_JSON).body(errorDto);
    }
}
