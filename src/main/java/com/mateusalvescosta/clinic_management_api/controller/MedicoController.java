package com.mateusalvescosta.clinic_management_api.controller;

import com.mateusalvescosta.clinic_management_api.dto.request.CreateMedicoRequest;
import com.mateusalvescosta.clinic_management_api.dto.request.UpdateMedicoRequest;
import com.mateusalvescosta.clinic_management_api.dto.response.MedicoSummaryResponse;
import com.mateusalvescosta.clinic_management_api.service.MedicoService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoService service;

    @PostMapping
    public void cadastrar(@RequestBody @Valid CreateMedicoRequest dados){
        service.cadastrar(dados);
    }

    @GetMapping
    public Page<MedicoSummaryResponse> listar(Pageable pageable) {
        return service.listar(pageable);
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable Long id, @RequestBody @Valid UpdateMedicoRequest dados) {
        service.atualizar(id, dados);
    }





}
