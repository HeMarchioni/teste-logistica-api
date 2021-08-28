package com.example.teste_logistica.model.enums.movimentacao;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum TipoMovimentacao {

    EMBARQUE("Embarque"),
    DESCARGA("Descarga"),
    GATE_IN("Gate In"),
    GATE_OUT("Gate out"),
    POSICIONAMENTO("Posicionamento"),
    PILHA("Pilha"),
    PESAGEM("Pesagem"),
    SCANNER("Scanner");

    private final String description;


}
