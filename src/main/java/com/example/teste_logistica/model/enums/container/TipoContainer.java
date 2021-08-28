package com.example.teste_logistica.model.enums.container;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum TipoContainer {

    VINTE("20"),
    QUARENTA("40");

    private final String description;

}
