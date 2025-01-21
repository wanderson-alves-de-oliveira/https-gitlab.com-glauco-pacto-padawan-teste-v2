package com.padwan.test.dto;

import java.util.ArrayList;

public class MestreDTO {
    public MestreDTO() {
    }

    String nome ;

    ArrayList<String> dicipulos = new ArrayList<>();


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<String> getDicipulos() {
        return dicipulos;
    }

    public void setDicipulos(ArrayList<String> dicipulos) {
        this.dicipulos = dicipulos;
    }
}
