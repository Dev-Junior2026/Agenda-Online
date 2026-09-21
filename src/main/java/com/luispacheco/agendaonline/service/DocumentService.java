package com.luispacheco.agendaonline.service;

import com.luispacheco.agendaonline.model.Document;
import com.luispacheco.agendaonline.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    // Obtener todos los documentos de un usuario específico
    public List<Document> getDocumentsByUserId(Long userId) {
        return documentRepository.findByUserId(userId);
    }

    // Guardar un documento
    public Document saveDocument(Document document) {
        if (document.getUploadedAt() == null) {
            document.setUploadedAt(LocalDateTime.now());
        }
        return documentRepository.save(document);
    }

    // Buscar un documento por su ID
    public Optional<Document> getDocumentById(Long id) {
        return documentRepository.findById(id);
    }

    // Eliminar un documento por su ID
    public void deleteDocument(Long id) {
        documentRepository.deleteById(id);
    }
}