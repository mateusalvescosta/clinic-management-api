package com.mateusalvescosta.clinic_management_api.dto.request;


import jakarta.validation.constraints.Pattern;

public record UpdateEnderecoRequest(

        String logradouro,

        String numero,

        String bairro,

        String cidade,

        String uf,

        String complemento,

        @Pattern(regexp = "\\d{8}") String cep) {

}
