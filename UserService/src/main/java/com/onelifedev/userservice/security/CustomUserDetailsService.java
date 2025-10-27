package com.onelifedev.userservice.security;

import com.onelifedev.userservice.models.User;
import com.onelifedev.userservice.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByEmail(email);

        if (optionalUser.isEmpty()) {
            throw new UsernameNotFoundException(email);
        }

        return new CustomUserDetails(optionalUser.get());
    }
}

//UserDetails customUserDetails = userDetailsService.loadByUsername(email);
//
//if(bcryptEncoder.matches(password, customUserDetails.getPassword())) {
//
//        }
