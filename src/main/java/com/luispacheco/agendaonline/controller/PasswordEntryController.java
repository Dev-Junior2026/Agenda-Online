package com.luispacheco.agendaonline.controller;

import com.luispacheco.agendaonline.model.PasswordEntry;
import com.luispacheco.agendaonline.service.PasswordEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/passwords")
public class PasswordEntryController {

    @Autowired
    private PasswordEntryService passwordEntryService;

    // Endpoint para listar contraseñas de un usuario: GET /api/passwords/user/{userId}
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<PasswordEntry>> getPasswordsByUser(@PathVariable Long userId) {
        List<PasswordEntry> passwords = passwordEntryService.getPasswordsByUserId(userId);
        return ResponseEntity.ok(passwords);
    }

    // Endpoint para registrar una contraseña: POST /api/passwords
    @PostMapping
    public ResponseEntity<PasswordEntry> createPassword(@RequestBody PasswordEntry passwordEntry) {
        PasswordEntry newPassword = passwordEntryService.savePassword(passwordEntry);
        return ResponseEntity.ok(newPassword);
    }

    // Endpoint para eliminar una contraseña: DELETE /api/passwords/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePassword(@PathVariable Long id) {
        if (passwordEntryService.getPasswordById(id).isPresent()) {
            passwordEntryService.deletePassword(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}