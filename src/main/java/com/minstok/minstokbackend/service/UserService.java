package com.minstok.minstokbackend.service;

import com.minstok.minstokbackend.dto.UserRegisterDto;
import com.minstok.minstokbackend.entity.User;
import com.minstok.minstokbackend.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.Validator;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.validateSuperAdmin();
    }

    public User registerUser(UserRegisterDto userRegisterDto) {
        User user = new User();
        user.setUsername(userRegisterDto.getUsername());
        user.setEmail(userRegisterDto.getEmail());
        user.setPasswordHash(passwordEncoder.encode(userRegisterDto.getPassword()));
        user.setRole(User.RoleType.ROLE_ADMIN);

        return userRepository.save(user);
    }

    private void validateSuperAdmin() {
        if (userRepository.findByUsername("superadmin").isPresent()) {
            return;
        }

        UserRegisterDto userRegisterDto = new UserRegisterDto();
        userRegisterDto.setUsername("superadmin");
        userRegisterDto.setEmail("kaan@kahraman.io");
        userRegisterDto.setPassword("password");
        registerUser(userRegisterDto);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

}
