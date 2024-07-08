package org.example.task1blogwithlogin.controller;

import lombok.RequiredArgsConstructor;
import org.example.task1blogwithlogin.dto.LoginDto;
import org.example.task1blogwithlogin.dto.RegisterDto;
import org.example.task1blogwithlogin.model.User;
import org.example.task1blogwithlogin.service.AuthenticationService;
import org.example.task1blogwithlogin.service.JwtService;
import org.example.task1blogwithlogin.utils.LoginResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;
    private final JwtService jwtService;


    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
        User user = authenticationService.signUp(registerDto);
        if (user != null) {
            return ResponseEntity.ok("User successfully registered!");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to register user.");
        }
    }



    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginDto loginDto) {
        User user = authenticationService.signIn(loginDto);
        String jwtToken = jwtService.generateToken(user);
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());
        return ResponseEntity.ok(loginResponse);
    }

}


