package com.luispacheco.agendaonline.service;

import com.luispacheco.agendaonline.model.User;
import com.luispacheco.agendaonline.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        // Aquí más adelante añadiremos el cifrado de contraseñas
        return userRepository.save(user);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}