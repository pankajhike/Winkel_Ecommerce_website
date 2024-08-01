package com.Winkel.Model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class user {

    private Long id;

    @NotNull(message = "Username must not be Blank")
    @Size(min = 5, message = "Username must be atleast 5 character")
    private String username;


    @NotNull(message = "Email must not be Blank")
    @Email(message = "Please provide valid email address")
    private String email;

    @NotNull(message = "Password must not be blank")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "Password must contain at least one letter, one number, and one special character")
    private String password;

    @NotNull(message = "First Name must not be Blank")
    @Size(min = 3, message = "Enter your First Name")
    private String firstName;

    @NotNull(message = "First Name must not be Blank")
    @Size(min = 3, message = "Enter your Lastname")
    private String lastName;

    @NotNull(message = "phone number must not be Blank")
    @Pattern(regexp="(^$|[0-9]{10})", message = "Mobile Number must be 10 digits")
    private String phoneNumber;


    @NotNull(message = "Address must not be Blank")
    @Size(min = 5, message = "Enter your Address")
    private String address;

    @NotNull(message = "City must not be Blank")
    @Size(min = 3, message = "Enter your City ")
    private String city;

    @NotNull(message = "State must not be Blank")
    @Size(min = 3, message = "Enter your State")
    private String state;

    @NotNull(message = "Zipcode must not be Blank")
    @Size(min = 3, message = "Enter your Zipcode")
    private String zipCode;
    private Role role;
    private boolean enabled = true;

//    private Set<Order> orders;

    enum Role {
        ROLE_USER,
        ROLE_ADMIN
    }
}
