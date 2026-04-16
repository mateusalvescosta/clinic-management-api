package com.mateusalvescosta.clinic_management_api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CreateEnderecoRequest(

        @NotBlank String logradouro,

        String numero,

        @NotBlank String bairro,

        @NotBlank String cidade,

        @NotBlank String uf,

        String complemento,

        @NotBlank @Pattern(regexp = "\\d{8}") String cep) {

}
