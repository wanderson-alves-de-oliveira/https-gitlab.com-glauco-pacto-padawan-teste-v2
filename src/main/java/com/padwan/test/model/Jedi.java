package com.padwan.test.model;
import com.padwan.test.enums.StatusJedi;

import javax.persistence.*;

@Entity
public class Jedi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private StatusJedi status;

    private int midichlorians;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mentor_id")
    private Jedi mentor;

    public Jedi() {
        // Construtor padrão
    }

    public Jedi(String nome, StatusJedi status, int midichlorians, Jedi mentor) {
        this.nome = nome;
        this.status = status;
        this.midichlorians = midichlorians;
        this.mentor = mentor;
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public StatusJedi getStatus() {
        return status;
    }

    public void setStatus(StatusJedi status) {
        this.status = status;
    }

    public int getMidichlorians() {
        return midichlorians;
    }

    public void setMidichlorians(int midichlorians) {
        this.midichlorians = midichlorians;
    }

    public Jedi getMentor() {
        return mentor;
    }

    public void setMentor(Jedi mentor) {
        this.mentor = mentor;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Status: " + status + ", Midichlorians: " + midichlorians + ", Mentor: " + (mentor != null ? mentor.getNome() : "Nenhum");
    }
}
