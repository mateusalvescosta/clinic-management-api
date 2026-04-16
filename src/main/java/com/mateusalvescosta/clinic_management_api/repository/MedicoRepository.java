package com.mateusalvescosta.clinic_management_api.repository;

import com.mateusalvescosta.clinic_management_api.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
}
