package com.padwan.test.dto;

public class JediDTO {

    private String name;
    private Integer status;
    private String mentor;
    private Integer midichlorians;

    public JediDTO() {
    }

    public JediDTO(String name, Integer status, String mentor, Integer midichlorians) {
        this.name = name;
        this.status = status;
        this.mentor = mentor;
        this.midichlorians = midichlorians;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
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
}