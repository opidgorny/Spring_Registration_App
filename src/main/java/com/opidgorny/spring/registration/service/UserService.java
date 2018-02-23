package com.opidgorny.spring.registration.service;

import com.opidgorny.spring.registration.model.User;
import com.opidgorny.spring.registration.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}
