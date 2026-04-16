package com.mateusalvescosta.clinic_management_api.service;

import com.mateusalvescosta.clinic_management_api.dto.request.CreateMedicoRequest;
import com.mateusalvescosta.clinic_management_api.dto.request.UpdateMedicoRequest;
import com.mateusalvescosta.clinic_management_api.dto.response.MedicoSummaryResponse;
import com.mateusalvescosta.clinic_management_api.model.Medico;
import com.mateusalvescosta.clinic_management_api.repository.MedicoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository repository;

    @Transactional
    public void cadastrar(CreateMedicoRequest dados){
        repository.save(new Medico(dados));
    }

    public Page<MedicoSummaryResponse> listar(Pageable pageable) {
        return repository.findAll(pageable).map(MedicoSummaryResponse::new);
    }

    @Transactional
    public void atualizar(Long id, UpdateMedicoRequest dados) {
        var medico = repository.getReferenceById(id);
        medico.update(dados);
    }





}
