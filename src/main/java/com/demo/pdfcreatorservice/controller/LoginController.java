package com.demo.pdfcreatorservice.controller;

import com.demo.pdfcreatorservice.dto.UserDto;
import com.demo.pdfcreatorservice.jwt.JwtService;
import com.demo.pdfcreatorservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @PostMapping("/public/register")
    public UserDto registerUser(@RequestBody UserDto userDto){
        return userService.register(userDto);
    }

    @GetMapping("/test")
    public String test(){
        return "hello";
    }

    @PostMapping("/public/login")
    public AuthResponse login(@RequestBody AuthRequest request){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.email,request.password));
        if(!authentication.isAuthenticated()){
            throw new UsernameNotFoundException("invalid request");
        }
        return new AuthResponse(jwtService.GenerateToken(request.email));
    }


    public record AuthRequest(String email, String password){}
    public record AuthResponse(String token){}
}
