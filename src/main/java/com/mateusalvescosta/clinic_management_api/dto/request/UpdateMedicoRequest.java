package com.mateusalvescosta.clinic_management_api.dto.request;

import com.mateusalvescosta.clinic_management_api.enumeration.Especialidade;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

public record UpdateMedicoRequest(
        String nome,

        @Email String email,

        @Pattern(regexp = "\\d{10,11}") String telefone,

        @Pattern(regexp = "\\d{4,6}-[A-Z]{2}") String crm,

        Especialidade especialidade,

        UpdateEnderecoRequest endereco) {

}
