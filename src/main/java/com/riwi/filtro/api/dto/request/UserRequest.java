package com.riwi.filtro.api.dto.request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    @NotBlank(message = "The user's name is required.")
    @Size(min = 10, max = 30)
    private String name;
    @NotBlank(message = "Email is required.")
    @Email(message = "Invalid email format.")
    private  String email;
    @NotBlank(message = "Password is required.")
    @Size(max = 20, message = "Password must not exceed {max} characters.")
    private String password;
    @NotBlank(message = "This field is required.")
    private boolean active;
    
    
}
