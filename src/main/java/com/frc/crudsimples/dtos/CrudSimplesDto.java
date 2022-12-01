package com.frc.crudsimples.dtos;

import jakarta.validation.constraints.NotBlank;

public class CrudSimplesDto {

    @NotBlank
    private String nomePessoa;
    @NotBlank
    private String telefone;

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
