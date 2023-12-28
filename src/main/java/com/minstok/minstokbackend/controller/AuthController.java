package com.minstok.minstokbackend.controller;

import com.minstok.minstokbackend.config.SecurityConfig;
import com.minstok.minstokbackend.dto.UserLoginDto;
import com.minstok.minstokbackend.dto.UserRegisterDto;
import com.minstok.minstokbackend.entity.User;
import com.minstok.minstokbackend.security.JWTUtil;
import com.minstok.minstokbackend.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    private final SecurityConfig securityConfig;

    private final JWTUtil jwtUtil;

    private final UserService userService;

    public AuthController(SecurityConfig securityConfig, JWTUtil jwtUtil, UserService userService) {
        this.securityConfig = securityConfig;
        this.jwtUtil = jwtUtil;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody UserLoginDto userLoginDto) {
        try {
            logger.info("Incoming login request for username: " + userLoginDto.getUsername() + ", and password is " + userLoginDto.getPassword() + ".");
            Authentication authentication = securityConfig.authenticationManagerBean().authenticate(
                    new UsernamePasswordAuthenticationToken(userLoginDto.getUsername(), userLoginDto.getPassword()));


            String jwt = jwtUtil.generateToken((UserDetails) authentication.getPrincipal());
            return ResponseEntity.ok(jwt);
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().body("Invalid username or password " + e.getMessage() + ".");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody UserRegisterDto userRegisterDto) {
        try {
            User user = userService.registerUser(userRegisterDto);
            return ResponseEntity.ok("User registered successfully with username: " + user.getUsername()
                    + " and email: " + user.getEmail() + ".");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Registration failed: " + e.getMessage());
        }
    }
}
