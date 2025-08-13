package com.exam_scheduler.Exam_Scheduler.controller;

import com.exam_scheduler.Exam_Scheduler.dto.AuthRequest;
import com.exam_scheduler.Exam_Scheduler.dto.AuthResponse;
import com.exam_scheduler.Exam_Scheduler.dto.UserRequest;
import com.exam_scheduler.Exam_Scheduler.model.User;
import com.exam_scheduler.Exam_Scheduler.security.JwtUtil;
import com.exam_scheduler.Exam_Scheduler.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthRequest authRequest){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
        );

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
        final String token = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthResponse(token));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid UserRequest userRequest){
        try{
            User user = new User(userRequest.getName(), userRequest.getEmail(), userRequest.getPassword(), "USER");
            User registeredUser = userService.registerUser(user);
            return ResponseEntity.ok("User registered successfully with email: " + registeredUser.getEmail());
        }catch(RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/test")
    public String testAuthentication() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "You are authenticated as: " + authentication.getName();
    }


}
