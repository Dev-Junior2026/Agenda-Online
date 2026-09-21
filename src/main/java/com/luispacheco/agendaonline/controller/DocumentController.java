package com.luispacheco.agendaonline.controller;

import com.luispacheco.agendaonline.model.Document;
import com.luispacheco.agendaonline.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    // Endpoint para listar documentos de un usuario: GET /api/documents/user/{userId}
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Document>> getDocumentsByUser(@PathVariable Long userId) {
        List<Document> documents = documentService.getDocumentsByUserId(userId);
        return ResponseEntity.ok(documents);
    }

    // Endpoint para registrar un documento: POST /api/documents
    @PostMapping
    public ResponseEntity<Document> createDocument(@RequestBody Document document) {
        Document newDocument = documentService.saveDocument(document);
        return ResponseEntity.ok(newDocument);
    }

    // Endpoint para eliminar un documento: DELETE /api/documents/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDocument(@PathVariable Long id) {
        if (documentService.getDocumentById(id).isPresent()) {
            documentService.deleteDocument(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}