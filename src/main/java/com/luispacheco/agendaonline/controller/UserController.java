package com.luispacheco.agendaonline.controller;

import com.luispacheco.agendaonline.model.User;
import com.luispacheco.agendaonline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Endpoint de Registro
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User newUser = userService.registerUser(user);
        return ResponseEntity.ok(newUser);
    }

    // Endpoint de Login: POST /api/users/login
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User loginRequest) {
        Optional<User> authenticatedUser = userService.loginUser(loginRequest.getEmail(), loginRequest.getPasswordHash());

        if (authenticatedUser.isPresent()) {
            return ResponseEntity.ok(authenticatedUser.get());
        }

        return ResponseEntity.status(401).body("Credenciales inválidas o usuario no encontrado");
    }
}