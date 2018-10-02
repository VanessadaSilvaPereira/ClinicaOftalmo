package com.inf3m171.vanessa.oftalmo.model;

import java.util.Date;

/**
 * Created by android on 01/10/2018.
 */

public class Consultas {
    private String id;
    private String hora;
    private String medico;
    private String paciente;
    private String data;
    //private String idPaciente;


    public Consultas() {
    }

    public Consultas(String id, String hora, String medico, String paciente, String data) {
        this.id = id;
        this.hora = hora;
        this.medico = medico;
        this.paciente = paciente;
        this.data = data;
        //this.idPaciente = idPaciente;
    }

   // public String getIdPaciente() {
       // return idPaciente;
    //}

   // public void setIdPaciente(String idPaciente) {
        //this.idPaciente = idPaciente;
   // }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
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
        return ( "Data: " + data + "\n" + "Hora: " +  hora + "\n"+ "Médico: " + medico);
    }
}
