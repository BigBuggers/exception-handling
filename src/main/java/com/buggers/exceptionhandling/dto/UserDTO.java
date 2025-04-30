package com.buggers.exceptionhandling.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDTO {
    @NotBlank(message = "Username is required")
    private String username;
    @Email(message = "Invalid email")
    @NotBlank(message = "Email is required")
    private String email;
    @NotBlank(message = "UserId is required")
    private String userId;
    @Size(min=4,max=8,message = "Password character length must be in 4 to 8 character")
    @NotBlank(message = "Password is required")
    private String password;
}
