package com.padwan.test.enums;

public enum StatusJedi {
    PADAWAN("Padawan"),
    JEDI("Jedi"),
    MESTRE_JEDI("Mestre Jedi");

    private final String status;

    StatusJedi(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return status;
    }
}
