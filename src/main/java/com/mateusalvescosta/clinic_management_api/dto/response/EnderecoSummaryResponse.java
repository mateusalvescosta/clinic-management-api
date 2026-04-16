package com.mateusalvescosta.clinic_management_api.dto.response;

import com.mateusalvescosta.clinic_management_api.model.Endereco;

public record EnderecoSummaryResponse(

        String logradouro,
        String numero,
        String bairro,
        String cidade,
        String uf,
        String complemento,
        String cep) {

    public EnderecoSummaryResponse(Endereco endereco) {
        this(endereco.getLogradouro(), endereco.getNumero(), endereco.getBairro(),
                endereco.getCidade(), endereco.getUf(), endereco.getComplemento(),
                endereco.getCep());
    }
}
