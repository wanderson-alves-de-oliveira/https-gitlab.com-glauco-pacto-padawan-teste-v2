package com.padwan.test.dto;

public class JediDTO {

    private String nome;
    private String status;
    private String mentor;
    private Integer midichlorians;
    private Double conexaoComAForca;

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMentor() {
        return mentor;
    }

    public void setMentor(String mentor) {
        this.mentor = mentor;
    }

    public Integer getMidichlorians() {
        return midichlorians;
    }

    public void setMidichlorians(Integer midichlorians) {
        this.midichlorians = midichlorians;
    }

    public Double getConexaoComAForca() {
        return conexaoComAForca;
    }

    public void setConexaoComAForca(Double conexaoComAForca) {
        this.conexaoComAForca = conexaoComAForca;
    }
}
