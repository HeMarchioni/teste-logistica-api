package com.example.teste_logistica.model.enums.container;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {

    CHEIO("Cheio"),
    VAZIO("vazio");

    private final String description;

}
