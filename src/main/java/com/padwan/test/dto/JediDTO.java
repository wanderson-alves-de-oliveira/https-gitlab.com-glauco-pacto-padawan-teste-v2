package com.padwan.test.dto;

import javax.validation.constraints.*;

public class JediDTO {

    @NotBlank(message = "Name cannot be null or empty")
    @Size(min = 3, message = "Name must have at least 3 characters")
    private String name;

    @NotBlank(message = "Status cannot be null or empty")
    @Size(max = 15, message = "Status must not exceed 15 characters")
    @Pattern(regexp = "padawan|jedi|mestre jedi", message = "Status must be one of: padawan, jedi, mestre jedi")
    private String status;

    @NotBlank(message = "Mentor cannot be null or empty")
    @Size(min = 3, message = "Mentor must have at least 3 characters")
    private String mentor;

    @NotNull(message = "Midichlorians count cannot be null")
    @Min(value = 1, message = "Midichlorians count must be at least 1")
    private Integer midichlorians;

    // Getters e setters
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
