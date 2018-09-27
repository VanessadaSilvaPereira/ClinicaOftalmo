package com.inf3m171.vanessa.oftalmo.model;

/**
 * Created by android on 25/09/2018.
 */

public class Medico {

    private String id, nome;

    public Medico() {
    }

    public Medico(String id, String nome) {
        this.id = id;
        this.nome = nome;
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
}
