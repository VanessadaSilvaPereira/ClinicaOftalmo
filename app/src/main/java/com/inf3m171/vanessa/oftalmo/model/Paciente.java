package com.inf3m171.vanessa.oftalmo.model;

/**
 * Created by android on 25/09/2018.
 */

public class Paciente {

    private String id, nome, cpf;


    public Paciente() {
    }

    public Paciente(String id, String nome, String cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return (nome);
    }
}
