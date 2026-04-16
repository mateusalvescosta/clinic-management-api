package com.mateusalvescosta.clinic_management_api.dto.request;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record UpdatePacienteRequest(

    

        @NotBlank String nome,

        @NotBlank @Email String email,

        @NotBlank @Pattern(regexp = "\\d{11}") String telefone,

        @NotBlank @CPF String cpf,

        @NotNull UpdateEnderecoRequest endereco) {

}
