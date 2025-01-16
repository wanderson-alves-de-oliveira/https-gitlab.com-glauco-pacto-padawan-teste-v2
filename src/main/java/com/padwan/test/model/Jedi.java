package com.padwan.test.model;

import com.padwan.test.model.enums.StatusJediEnum;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Jedi implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Integer status;
    private String mentor;
    private Integer midichlorians;

    public Jedi() {
    }

    public Jedi(String name, StatusJediEnum status, String mentor, int midichlorians) {
        this.name = name;
        this.status = status.getCode();
        this.mentor = mentor;
        this.midichlorians = midichlorians;
    }

    @Override
    public String toString() {
        return "Jedi{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", mentor='" + mentor + '\'' +
                ", midichlorians=" + midichlorians +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Jedi jedi = (Jedi) o;
        return Objects.equals(id, jedi.id) && Objects.equals(name, jedi.name) && Objects.equals(mentor, jedi.mentor) && Objects.equals(midichlorians, jedi.midichlorians);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, mentor, midichlorians);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StatusJediEnum getStatus() {
        return StatusJediEnum.toEnum(status);
    }

    public void setStatus(StatusJediEnum status) {
        this.status = status.getCode();
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


}
