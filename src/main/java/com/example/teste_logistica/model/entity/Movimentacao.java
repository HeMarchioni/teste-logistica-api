package com.example.teste_logistica.model.entity;


import com.example.teste_logistica.model.enums.movimentacao.TipoMovimentacao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Gerar o valor automaticamente do id
    private Long id;


    @Enumerated(EnumType.STRING)
    private TipoMovimentacao ds_Tipo;

    @Column(nullable = false, length = 50)
    private Date dt_Inicio;

    @Column(nullable = false, length = 50)
    private Date dt_Final;


}
