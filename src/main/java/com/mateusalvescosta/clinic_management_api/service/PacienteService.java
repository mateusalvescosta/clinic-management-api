package com.mateusalvescosta.clinic_management_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mateusalvescosta.clinic_management_api.dto.request.CreatePacienteRequest;
import com.mateusalvescosta.clinic_management_api.dto.request.UpdatePacienteRequest;
import com.mateusalvescosta.clinic_management_api.dto.response.PacienteSummaryResponse;
import com.mateusalvescosta.clinic_management_api.model.Paciente;
import com.mateusalvescosta.clinic_management_api.repository.PacienteRepository;

import jakarta.transaction.Transactional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;

    @Transactional
    public void cadastrar(CreatePacienteRequest dados) {
        repository.save(new Paciente(dados));
    }

    public Page<PacienteSummaryResponse> listar(Pageable pageable) {
        return repository.findAll(pageable).map(PacienteSummaryResponse::new);
    }

    @Transactional
    public void atualizar(Long id, UpdatePacienteRequest dados) {
        var paciente = repository.getReferenceById(id);
        paciente.update(dados);
    }
}
