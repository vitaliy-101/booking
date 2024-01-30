package com.example.booking.dtos.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserBaseDto {
    @NotBlank
    private String email;
    @NotBlank
    @Size(min = 5, max = 100)
    private String password;
}
