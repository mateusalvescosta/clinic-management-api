package com.mateusalvescosta.clinic_management_api.model;

import com.mateusalvescosta.clinic_management_api.dto.request.CreateMedicoRequest;
import com.mateusalvescosta.clinic_management_api.dto.request.UpdateMedicoRequest;
import com.mateusalvescosta.clinic_management_api.enumeration.Especialidade;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "medico")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    public Medico(CreateMedicoRequest dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
    }

    public void update(UpdateMedicoRequest dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.email() != null) {
            this.email = dados.email();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if (dados.crm() != null) {
            this.crm = dados.crm();
        }
        if (dados.especialidade() != null) {
            this.especialidade = dados.especialidade();
        }
        if (dados.endereco() != null) {
            this.endereco.update(dados.endereco());
        }
    }
}