package com.Winkel.Dto;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data

public class AdminDto {
    @Size(min = 3, max = 10, message = "Invalid first name (3-10 character)")
    private String firstName;
    @Size(min = 3, max =10, message = "Invalid last name(3-10 character")
    private String lastname;

    private String username;
    @Size(min = 5, max =15, message = "Invalid password (5-15 character")

    private String password;
    private String repeatPassword;
}
