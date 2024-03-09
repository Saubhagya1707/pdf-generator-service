package com.demo.pdfcreatorservice.service;

import com.demo.pdfcreatorservice.dto.UserDto;
import com.demo.pdfcreatorservice.model.User;
import com.demo.pdfcreatorservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService  {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public UserDto register(UserDto userDto){
        Optional<User> user = userRepository.findByEmail(userDto.email());
        if(user.isPresent()){
            throw new RuntimeException("User already exists!");
        }

        User user1 = User.builder()
                .email(userDto.email())
                .password(passwordEncoder.encode(userDto.password()))
                .role(userDto.role())
                .build();

        return UserDto.of(userRepository.save(user1));
    }




}
