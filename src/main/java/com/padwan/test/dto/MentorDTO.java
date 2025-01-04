package com.padwan.test.dto;

import java.util.Set;

public class MentorDTO {

    private String nome;
    private String status;
    private Set<String> aprendizes;
    
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
    public Set<String> getAprendizes() {
        return aprendizes;
    }
    public void setAprendizes(Set<String> aprendizes) {
        this.aprendizes = aprendizes;
    }
}
