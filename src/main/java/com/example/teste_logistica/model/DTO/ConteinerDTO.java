package com.example.teste_logistica.model.DTO;

import com.example.teste_logistica.model.enums.container.Categoria;
import com.example.teste_logistica.model.enums.container.Status;
import com.example.teste_logistica.model.enums.container.TipoContainer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConteinerDTO {


    private Long id;

    @NotEmpty
    @Size(min = 2, max = 50)
    private String nm_Cliente;

    @NotEmpty
    @Size(min = 11, max = 11)
    private String cd_Container;

    @Enumerated(EnumType.STRING)
    private TipoContainer ds_Tipo;

    @Enumerated(EnumType.STRING)
    private Status ds_Status;

    @Enumerated(EnumType.STRING)
    private Categoria ds_Categoria;

    @Valid
    private List<MovimentacaoDTO> movimentacaos;

}
