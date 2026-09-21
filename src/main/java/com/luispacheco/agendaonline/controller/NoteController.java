package com.luispacheco.agendaonline.controller;

import com.luispacheco.agendaonline.model.Note;
import com.luispacheco.agendaonline.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    // Endpoint para listar las notas de un usuario: GET /api/notes/user/{userId}
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Note>> getNotesByUser(@PathVariable Long userId) {
        List<Note> notes = noteService.getNotesByUserId(userId);
        return ResponseEntity.ok(notes);
    }

    // Endpoint para crear una nueva nota: POST /api/notes
    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note) {
        Note newNote = noteService.saveNote(note);
        return ResponseEntity.ok(newNote);
    }

    // Endpoint para eliminar una nota: DELETE /api/notes/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id) {
        if (noteService.getNoteById(id).isPresent()) {
            noteService.deleteNote(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}