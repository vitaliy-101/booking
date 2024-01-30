package com.example.booking.dtos.user;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDtoIn extends UserBaseDto{
    @NotBlank
    private String userName;
}
