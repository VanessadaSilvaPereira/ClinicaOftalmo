package com.inf3m171.vanessa.oftalmo.model;

/**
 * Created by android on 25/09/2018.
 */

public class Medico {

    private String nome;
    private String especialidade;
    private String id;


    public Medico() {
    }

    public Medico(String nome, String especialidade, String id) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
