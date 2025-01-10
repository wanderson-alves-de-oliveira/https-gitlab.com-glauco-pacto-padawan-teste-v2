package com.padwan.test.dto;

import com.padwan.test.entity.Mentor;

public class JediDTO {

    private String nome;
    private String status;
    private Mentor mentor;
    private int midichlorians;

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

    public Mentor getMentor() {
        return mentor;
    }

    public void setMentor(Mentor mentor) {
        this.mentor = mentor;
    }

    public int getMidichlorians() {
        return midichlorians;
    }

    public void setMidichlorians(int midichlorians) {
        this.midichlorians = midichlorians;
    }
}
