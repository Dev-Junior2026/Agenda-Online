package com.luispacheco.agendaonline.service;

import com.luispacheco.agendaonline.model.Note;
import com.luispacheco.agendaonline.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    // Obtener todas las notas de un usuario específico
    public List<Note> getNotesByUserId(Long userId) {
        return noteRepository.findByUserId(userId);
    }

    // Guardar o actualizar una nota
    public Note saveNote(Note note) {
        note.setUpdatedAt(LocalDateTime.now());
        return noteRepository.save(note);
    }

    // Buscar una nota por su ID
    public Optional<Note> getNoteById(Long id) {
        return noteRepository.findById(id);
    }

    // Eliminar una nota por su ID
    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }
}