package com.app.Dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {
    @NotNull(message = "Name not be null")
    @Size(min=10, max=10, message = "Mobile Number Must be Ten Digit")
    private String mobile;


    private String password;
}
