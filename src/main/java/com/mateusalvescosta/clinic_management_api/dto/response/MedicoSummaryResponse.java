package com.mateusalvescosta.clinic_management_api.dto.response;

import com.mateusalvescosta.clinic_management_api.enumeration.Especialidade;
import com.mateusalvescosta.clinic_management_api.model.Medico;

public record MedicoSummaryResponse(

        Long id,
        String name,
        String email,
        String telefone,
        Especialidade especialidade) {

    public MedicoSummaryResponse(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getTelefone(), medico.getEspecialidade());
    }
}
