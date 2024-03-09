package com.demo.pdfcreatorservice.dto;

import com.demo.pdfcreatorservice.model.User;

public record UserDto(String email, String password, User.Role role) {
    public UserDto(String email, String password, User.Role role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }
    // Non-canonical constructor that delegates to the primary constructor
    public UserDto(String email, User.Role role){
        this(email,null,role);
    }
    public static UserDto of(User user){
        return new UserDto(user.getEmail(),user.getRole());
    }
}
