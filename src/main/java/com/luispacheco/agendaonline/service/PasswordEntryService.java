package com.luispacheco.agendaonline.service;

import com.luispacheco.agendaonline.model.PasswordEntry;
import com.luispacheco.agendaonline.repository.PasswordEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PasswordEntryService {

    @Autowired
    private PasswordEntryRepository passwordEntryRepository;

    // Obtener todas las contraseñas de un usuario específico
    public List<PasswordEntry> getPasswordsByUserId(Long userId) {
        return passwordEntryRepository.findByUserId(userId);
    }

    // Guardar una entrada de contraseña (más adelante integraremos cifrado avanzado)
    public PasswordEntry savePassword(PasswordEntry passwordEntry) {
        return passwordEntryRepository.save(passwordEntry);
    }

    // Buscar una entrada por su ID
    public Optional<PasswordEntry> getPasswordById(Long id) {
        return passwordEntryRepository.findById(id);
    }

    // Eliminar una entrada por su ID
    public void deletePassword(Long id) {
        passwordEntryRepository.deleteById(id);
    }
}