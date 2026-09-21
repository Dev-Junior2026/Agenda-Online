package com.luispacheco.agendaonline.service;

import com.luispacheco.agendaonline.model.Appointment;
import com.luispacheco.agendaonline.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    // Obtener todas las citas de un usuario específico
    public List<Appointment> getAppointmentsByUserId(Long userId) {
        return appointmentRepository.findByUserId(userId);
    }

    // Guardar o actualizar una cita
    public Appointment saveAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    // Buscar una cita por su ID
    public Optional<Appointment> getAppointmentById(Long id) {
        return appointmentRepository.findById(id);
    }

    // Eliminar una cita por su ID
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
}