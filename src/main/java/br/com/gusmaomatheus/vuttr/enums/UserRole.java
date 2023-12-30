package br.com.gusmaomatheus.vuttr.enums;

import lombok.Getter;

@Getter
public enum UserRole {
    ADMIN("admin"),
    COMMON("common");

    private final String role;

    UserRole(String role) {
        this.role = role;
    }

}
