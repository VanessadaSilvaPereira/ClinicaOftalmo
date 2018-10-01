package com.inf3m171.vanessa.oftalmo.model;

import java.util.Date;

/**
 * Created by android on 01/10/2018.
 */

public class Consultas {
    private String id;
    private String hora;
    private Medico medico;
    private Paciente paciente;
    private Date data;


    public Consultas() {
    }

    public Consultas(String id, String hora, Medico medico, Paciente paciente, Date data) {
        this.id = id;
        this.hora = hora;
        this.medico = medico;
        this.paciente = paciente;
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return (paciente + "\n" + data + "\n" + hora + "\n" + medico);
    }
}
