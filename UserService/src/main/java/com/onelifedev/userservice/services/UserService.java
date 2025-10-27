package com.onelifedev.userservice.services;

import com.onelifedev.userservice.exceptions.InvalidTokenException;
import com.onelifedev.userservice.exceptions.PasswordMismatchException;
import com.onelifedev.userservice.models.User;

public interface UserService {
    User signup(String name, String email, String password);

    String login(String email, String password) throws PasswordMismatchException;

    User validateToken(String tokenValue) throws InvalidTokenException;
}
