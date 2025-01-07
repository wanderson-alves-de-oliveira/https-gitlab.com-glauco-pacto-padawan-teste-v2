package com.padwan.test.dto;

import javax.persistence.*;
import java.util.List;

@Entity
public class Padawan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String status;
    private Integer ranking;
    private String mentor;
    private Integer midichlorians;
    private String planeta;
    private String classe;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "padawan_skills",
        joinColumns = @JoinColumn(name = "padawan_id"),
        inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private List<Skill> skills;

    public Padawan() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
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

    public String getPlaneta() {
        return planeta;
    }

    public void setPlaneta(String planeta) {
        this.planeta = planeta;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }
}
