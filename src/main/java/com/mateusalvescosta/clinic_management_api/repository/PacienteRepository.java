package com.mateusalvescosta.clinic_management_api.repository;

import com.mateusalvescosta.clinic_management_api.model.Paciente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
