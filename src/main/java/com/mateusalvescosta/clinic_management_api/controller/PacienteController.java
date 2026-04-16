package com.mateusalvescosta.clinic_management_api.controller;

import com.mateusalvescosta.clinic_management_api.dto.request.CreatePacienteRequest;
import com.mateusalvescosta.clinic_management_api.dto.request.UpdatePacienteRequest;
import com.mateusalvescosta.clinic_management_api.dto.response.PacienteSummaryResponse;
import com.mateusalvescosta.clinic_management_api.service.PacienteService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacienteService service;

    @PostMapping
    @Transactional
    public void cadastrarPaciente(@RequestBody @Valid CreatePacienteRequest dados) {
        service.cadastrar(dados);
    }

    @GetMapping
    public Page<PacienteSummaryResponse> listar(Pageable pageable) {
        return service.listar(pageable);
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable Long id, @RequestBody @Valid UpdatePacienteRequest dados) {
        service.atualizar(id, dados);
    }

}
