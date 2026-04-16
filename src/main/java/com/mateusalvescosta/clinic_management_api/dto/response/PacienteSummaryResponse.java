package com.mateusalvescosta.clinic_management_api.dto.response;

import com.mateusalvescosta.clinic_management_api.model.Paciente;

public record PacienteSummaryResponse(

        Long id,
        String nome,
        String email,
        String telefone,
        String cpf) {

    public PacienteSummaryResponse(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getCpf());
    }
}
