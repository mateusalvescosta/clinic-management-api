package com.mateusalvescosta.clinic_management_api.dto.request;

import com.mateusalvescosta.clinic_management_api.enumeration.Especialidade;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CreateMedicoRequest(

                @NotBlank String nome,

                @Email String email,

                @NotBlank @Pattern(regexp = "\\d{11}") String telefone,

                @NotBlank @Pattern(regexp = "\\d{4,6}-[A-Z]{2}") String crm,

                @NotNull Especialidade especialidade,

                @NotNull @Valid CreateEnderecoRequest endereco) {
}
