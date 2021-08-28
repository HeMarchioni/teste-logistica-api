package com.example.teste_logistica.model.DTO;

import com.example.teste_logistica.model.enums.container.Categoria;
import com.example.teste_logistica.model.enums.container.Status;
import com.example.teste_logistica.model.enums.container.TipoContainer;
import com.example.teste_logistica.model.enums.movimentacao.TipoMovimentacao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovimentacaoDTO {


    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoMovimentacao ds_Tipo;


    @NotEmpty
    @Size(min = 10, max = 50)
    private String dt_Inicio;

    @NotEmpty
    @Size(min = 10, max = 50)
    private String dt_Final;


}
