package com.padwan.test.model.enums;

public enum StatusJediEnum {
    PADAWAN(0, "Padawan"), JEDI(1, "Jedi"), JEDI_MASTER(2, "Jedi Master");

    private Integer code;
    private String description;

    StatusJediEnum(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static StatusJediEnum toEnum(Integer code) {
        if (code == null) {
            return null;
        }
        for (StatusJediEnum x : StatusJediEnum.values()) {
            if (code.equals(x.getCode())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
