package com.example.teste_logistica.model.enums.container;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum Categoria {

    IMPORTACAO("Importação"),
    EXPORTACAO("Exportação");

    private final String description;


}
