package com.example.demo.enam;

import javax.persistence.Embeddable;
public enum Role {
    ADMIN("ADMIN"),
    USER("USER");

    private String ordinal;

    Role(String ordinal) {
        this.ordinal = ordinal;
    }
}
